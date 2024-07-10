package com.mspprarosaje.arosaje.security.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.user.UserType;
import com.mspprarosaje.arosaje.security.config.JwtService;
import com.mspprarosaje.arosaje.security.token.Token;
import com.mspprarosaje.arosaje.security.token.TokenRepository;
import com.mspprarosaje.arosaje.security.token.TokenType;
import com.mspprarosaje.arosaje.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import com.mspprarosaje.arosaje.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private static  final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    public AuthenticationResponse register(RegisterRequest request) {
        User user;
        AuthenticationResponse authenticationResponse = null;

        try {
            if (request == null) {
                throw new NullPointerException();
            }
            if (this.repository.findByEmail(request.getEmail()).isPresent()) {
                throw new IllegalArgumentException();
            }
            user = User.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .userType(request.getUserType())
                    .build();
            User savedUser = repository.save(user);
            String jwtToken = jwtService.generateToken(user);
            String refreshToken = jwtService.generateRefreshToken(user);

            saveUserToken(savedUser, jwtToken);

            authenticationResponse = AuthenticationResponse.builder()
                    .user(UserMinimalDTO.builder()
                            .id(user.getId())
                            .firstName(user.getFirstName())
                            .lastName(user.getLastName())
                            .userType(UserType.USER)
                            .build()
                    )
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .build();

        } catch (Exception ex) {
            authenticationResponse = null;
        }
        return authenticationResponse;
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail()).get();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .user(UserMinimalDTO.builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .userType(UserType.USER)
                        .build()
                )
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        try {
            logger.debug("Début de la révocation des jetons pour l'utilisateur avec ID: {}", user.getId());

            List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
            logger.debug("Jetons valides récupérés: {}", validUserTokens);

            if (validUserTokens.isEmpty()) {
                logger.debug("Aucun jeton valide trouvé pour l'utilisateur avec ID: {}", user.getId());
                return;
            }

            validUserTokens.forEach(token -> {
                logger.debug("Révocation du jeton avec ID: {}", token.getId());
                token.setExpired(true);
                token.setRevoked(true);
            });

            tokenRepository.saveAll(validUserTokens);
            logger.debug("Tous les jetons valides ont été révoqués pour l'utilisateur avec ID: {}", user.getId());
        } catch (Exception e) {
            logger.error("Erreur lors de la révocation des jetons pour l'utilisateur avec ID: {}", user.getId(), e);
            throw e;
        }
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}

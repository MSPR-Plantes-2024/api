package com.mspprarosaje.arosaje.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.mspprarosaje.arosaje.api.enumerated.Permission.*;
import static com.mspprarosaje.arosaje.api.enumerated.UserType.ADMIN;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private static final String[] WHITE_LIST = {
            "/api/v1/auth/**",
            "/api/v1/demo-controller/**",
            "/api/v1/addresses/**",
            "/api/v1/messages/**",
            "/api/v1/plants/**",
            "/api/v1/comments/**",
            "/api/v1/publications/**",
            "/api/v1/reports/**",
            "/api/v1/pictures/**",
            "/api/v1/users/user/**",
            "/api/v1/plantsConditions/**",
			"/api-docs",
			"/swagger-ui/**"
    };
    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST).permitAll()
                                .requestMatchers("/api/v1/users/**").hasAnyRole(ADMIN.name())
                                .requestMatchers(GET, "/api/v1/users/admin/**").hasAnyAuthority("ROLE_" + ADMIN_READ.name())
                                .requestMatchers(POST, "/api/v1/users/admin/**").hasAnyAuthority("ROLE_" + ADMIN_CREATE.name())
                                .requestMatchers(PUT, "/api/v1/users/admin/**").hasAnyAuthority("ROLE_" + ADMIN_UPDATE.name())
                                .requestMatchers(DELETE, "/api/v1/users/admin/**").hasAnyAuthority("ROLE_" + ADMIN_DELETE.name())
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> logout.logoutSuccessUrl("/api/v1/auth/logout")
                        .addLogoutHandler(logoutHandler)
                        .logoutSuccessHandler((request, response, authentication)
                                -> SecurityContextHolder.clearContext()));
        return http.build();
    }
}

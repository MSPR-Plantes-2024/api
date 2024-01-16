package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserAccountDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserCreateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.model.UserType;
import com.mspprarosaje.arosaje.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserMinimalDTO>> getUsers(){
        return ResponseEntity.ok(
                userService.getUsers()
                        .stream()
                        .map(this::mapToDto)
                        .toList()
        );
    }

    @GetMapping("account/{id}")
    public ResponseEntity<UserAccountDTO> getUserAccountById(@PathVariable() Integer id){
        log.atInfo().log("getUserAccountById {}", id);
        Optional<User> userOptional = userService.getUserAccountById(id);
        Optional<UserAccountDTO> userAccountDTOOptional = userOptional.map(user -> UserAccountDTO.builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .userType(this.mapToUserTypeDto(user.getUserType()))
                    .build());

        return ResponseEntity.of(userAccountDTOOptional);
    }

    @PostMapping
    public ResponseEntity<UserCreateDTO> createUser(@RequestBody UserCreateDTO userCreateDTO){
        log.atInfo().log("createUser");
        User user = new User();
        user.setFirstName(userCreateDTO.getFirstName());
        user.setLastName(userCreateDTO.getLastName());
        user.setEmail(userCreateDTO.getEmail());
        user.setPassword(userCreateDTO.getPassword());

        UserType userType = convertDtoToUserType(userCreateDTO.getUserType());
        user.setUserType(userType);

        User createdUser = userService.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserCreateDTO.builder()
                        .firstName(createdUser.getFirstName())
                        .lastName(createdUser.getLastName())
                        .email(createdUser.getEmail())
                        .password(createdUser.getPassword())
                        // Remarque : normalement, on ne renvoie pas le mot de passe
                        .userType(UserTypeDTO.builder()
                                .name(userType.getName())
                                .id(userType.getId())
                                .build())
                        .build());
    }

    private UserType convertDtoToUserType(UserTypeDTO userTypeDTO) {
        UserType userType = new UserType();
        userType.setId(userTypeDTO.getId());
        userType.setName(userTypeDTO.getName());
        return userType;
    }

    private UserMinimalDTO mapToDto(User user){
        return UserMinimalDTO
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    private UserTypeDTO mapToUserTypeDto(UserType userType){
        return UserTypeDTO.builder()
                .id(userType.getId())
                .name(userType.getName())
                .build();
    }
}

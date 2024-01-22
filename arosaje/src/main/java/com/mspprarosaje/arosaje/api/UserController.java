package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserAccountDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserCreateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.api.mappers.UserMapper;
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
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserMinimalDTO>> getUsers(){
        return ResponseEntity.ok(userMapper.toMinimalDtos(userService.getUsers()));
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

        User createdUser = userService.createUser(this.userMapper.fromDto(userCreateDTO));

        // UserMapper va mapper l'ensemble de l'objet User, y compris UserType.
        UserCreateDTO createdUserDTO = userMapper.toCreateDto(createdUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDTO);
    }

    private UserType convertDtoToUserType(UserTypeDTO userTypeDTO) {
        UserType userType = new UserType();
        userType.setId(userTypeDTO.getId());
        userType.setName(userTypeDTO.getName());
        return userType;
    }

    private UserTypeDTO mapToUserTypeDto(UserType userType){
        return UserTypeDTO.builder()
                .id(userType.getId())
                .name(userType.getName())
                .build();
    }
}

package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserAccountDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserCreateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.api.mappers.user.UserCreateMapper;
import com.mspprarosaje.arosaje.api.mappers.user.UserMapper;
import com.mspprarosaje.arosaje.api.mappers.user.UserMinimalMapper;
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
    private final UserMinimalMapper userMinimalMapper;
    private final UserCreateMapper userCreateMapper;

    @GetMapping
    public ResponseEntity<List<UserMinimalDTO>> getUsers(){
        return ResponseEntity.ok(userMinimalMapper.toMinimalDtos(userService.getUsers()));
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
        User createdUser = userService.saveUser(
                this.userCreateMapper.fromDto(userCreateDTO),
                userCreateDTO.getUserType()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(this.userCreateMapper.toDto(createdUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable() Integer id,
                                              @RequestBody UserDTO userDTO){
        if (!id.equals(userDTO.getId())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

        if (!this.userService.existsById(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        User updatedUser = userService.saveUser(this.userMapper.fromDto(userDTO), userDTO.getUserType().getId());
        return ResponseEntity.ok(this.userMapper.toDto(updatedUser));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable() Integer id) {
        if(!this.userService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.userService.deleteById(id);
        if(this.userService.existsById(id)){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private UserTypeDTO mapToUserTypeDto(UserType userType){
        return UserTypeDTO.builder()
                .id(userType.getId())
                .name(userType.getName())
                .build();
    }
}

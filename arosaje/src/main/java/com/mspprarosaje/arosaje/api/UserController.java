package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.user.*;
import com.mspprarosaje.arosaje.api.mappers.user.UserCreateMapper;
import com.mspprarosaje.arosaje.api.mappers.user.UserMapper;
import com.mspprarosaje.arosaje.api.mappers.user.UserMinimalMapper;
import com.mspprarosaje.arosaje.api.mappers.user.UserUpdateMapper;
import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserMinimalMapper userMinimalMapper;
    private final UserCreateMapper userCreateMapper;
    private final UserUpdateMapper userUpdateMapper;

    @GetMapping("/admin")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(userMapper.toDtos(userService.getUsers()));
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<UserDTO> getUserAccountByIdAdmin(@PathVariable() Integer id){
        return ResponseEntity.of(this.userService.getUserAccountByIdAdmin(id).map(this.userMapper::toDto));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserMinimalDTO> getUserAccountById(@PathVariable() Integer id){
        return ResponseEntity.of(this.userService.getUserAccountById(id).map(this.userMinimalMapper::toMinimalDto));
    }

    @PostMapping("/admin")
    public ResponseEntity<UserCreateDTO> createUser(@RequestBody UserCreateDTO userCreateDTO){
        User createdUser = userService.saveUser(
                this.userCreateMapper.fromDto(userCreateDTO),
                userCreateDTO.getUserType()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(this.userCreateMapper.toDto(createdUser));
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<UserUpdateDTO> updateUser(@PathVariable() Integer id,
                                                        @RequestBody UserUpdateDTO userUpdateDTO){
        if (!id.equals(userUpdateDTO.getId())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

        if (!this.userService.existsById(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        User updatedUser = userService.saveUser(
                this.userUpdateMapper.fromDto(userUpdateDTO),
                userUpdateDTO.getUserType()
        );
        return ResponseEntity.ok(this.userUpdateMapper.toDto(updatedUser));
    }


    @DeleteMapping("/admin/{id}")
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
}

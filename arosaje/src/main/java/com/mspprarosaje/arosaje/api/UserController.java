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

    @GetMapping
    public ResponseEntity<List<UserMinimalDTO>> getUsers(){
        return ResponseEntity.ok(userMinimalMapper.toMinimalDtos(userService.getUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserAccountById(@PathVariable() Integer id){
        return ResponseEntity.of(this.userService.getUserAccountById(id).map(this.userMapper::toDto));
    }

    @PostMapping
    public ResponseEntity<UserCreateDTO> createUser(@RequestBody UserCreateDTO userCreateDTO){
        User createdUser = userService.saveUser(
                this.userCreateMapper.fromDto(userCreateDTO),
                userCreateDTO.getUserType()
                        //.getId()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(this.userCreateMapper.toDto(createdUser));
    }

    @PutMapping("/{id}")
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
                        //.getId()
        );
        return ResponseEntity.ok(this.userUpdateMapper.toDto(updatedUser));
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
}

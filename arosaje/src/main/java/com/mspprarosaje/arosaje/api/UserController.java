package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.UserDTO;
import com.mspprarosaje.arosaje.api.mappers.UserMapper;
import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    /***
     * Get userDTO by id
     * @param id id of userDTO
     * @return UserDTO object
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable() Integer id){
        ResponseEntity responseEntity = ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
        Optional<User> user = this.userService.getUserById(id);
        if(user.isPresent()){
            responseEntity = ResponseEntity.ok(Optional.ofNullable(this.userMapper.toDto(user.get())));
        }
        return responseEntity;
    }
}

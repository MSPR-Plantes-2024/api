package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
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

    private UserMinimalDTO mapToDto(User user){
        return UserMinimalDTO
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}

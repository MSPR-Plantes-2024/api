package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.UserMinimalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<UserMinimalDTO>> getUsers(){
        UserMinimalDTO userMinimalDTO = UserMinimalDTO
                .builder()
                .id(1)
                .firstName("Louis")
                .lastName("Dupont")
                .build();
        return ResponseEntity.ok(List.of(userMinimalDTO));
    }
}

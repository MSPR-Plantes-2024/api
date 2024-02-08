package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.mappers.UserTypeMapper;
import com.mspprarosaje.arosaje.services.UserTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user_types")
@RequiredArgsConstructor
@Slf4j
public class UserTypeController {
    private final UserTypeService userTypeService;
    private final UserTypeMapper userTypeMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserTypeDTO> getUserTypeById(@PathVariable() Integer id){
        return ResponseEntity.of(this.userTypeService.getUserTypeById(id).map(this.userTypeMapper::toDto));
    }
}

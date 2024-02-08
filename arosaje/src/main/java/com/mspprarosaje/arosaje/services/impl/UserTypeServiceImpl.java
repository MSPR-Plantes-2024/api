package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.model.UserType;
import com.mspprarosaje.arosaje.repositories.UserTypeRepository;
import com.mspprarosaje.arosaje.services.UserTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserTypeServiceImpl implements UserTypeService {
    private final UserTypeRepository userTypeRepository;
    @Override
    public Optional<UserType> getUserTypeById(int id){
        return userTypeRepository.findById(id);
    }
}

package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.repositories.UserRepository;
import com.mspprarosaje.arosaje.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> getUserById(Integer id) {
        return this.userRepository.findById(id);
    }
}

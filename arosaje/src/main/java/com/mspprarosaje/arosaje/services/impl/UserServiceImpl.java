package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.repositories.UserRepository;
import com.mspprarosaje.arosaje.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserAccountById(Integer id){
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user){
        return this.userRepository.save(user);
    }
}

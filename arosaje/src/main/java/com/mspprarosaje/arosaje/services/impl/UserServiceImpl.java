package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.api.enumerated.UserType;
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
    public Optional<User> getUserAccountById(int id){
        return userRepository.findById(id);
    }

/*    @Override
    public User saveUser(User user, int userTypeId){
        return this.userRepository.save(user);
    }*/
    @Override
    public User saveUser(User user, UserType userType){
        return this.userRepository.save(user);
    }

    @Override
    public boolean existsById(int id) {
        return this.userRepository.existsById(id);
    }

    @Override
    public void deleteById(int id){
        this.userRepository.deleteById(id);
    }

}

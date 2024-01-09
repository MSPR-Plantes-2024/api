package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.repositories.UserRepository;
import com.mspprarosaje.arosaje.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> getUsers(){
        /*
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("Louis");
        user1.setLastName("Dupont");
        User user2 = new User();
        user2.setId(2);
        user2.setFirstName("Marie");
        user2.setLastName("Trocard");
        return List.of(user1, user2);
        */

        return userRepository.findAll();
    }
}

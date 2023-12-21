package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getUsers(){
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("Louis");
        user1.setLastName("Dupont");
        User user2 = new User();
        user2.setId(2);
        user2.setFirstName("Marie");
        user2.setLastName("Trocard");
        return List.of(user1, user2);
    }
}

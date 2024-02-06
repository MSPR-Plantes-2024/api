package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    Optional<User> getUserAccountById(Integer id);
    User saveUser(User user, int userTypeId);
    boolean existsById(Integer id);
    void deleteById(Integer id);
}

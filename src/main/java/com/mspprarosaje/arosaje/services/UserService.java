package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.user.UserType;
import com.mspprarosaje.arosaje.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    Optional<User> getUserAccountByIdAdmin(int id);
    Optional<User> getUserAccountById(int id);
    //User saveUser(User user, int userTypeId);
    User saveUser(User user, UserType userType);
    boolean existsById(int id);
    void deleteById(int id);
}

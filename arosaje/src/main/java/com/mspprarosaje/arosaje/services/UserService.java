package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Integer id);
}

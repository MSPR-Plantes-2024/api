package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.UserType;

import java.util.Optional;

public interface UserTypeService {
    Optional<UserType> getUserTypeById(int id);
}

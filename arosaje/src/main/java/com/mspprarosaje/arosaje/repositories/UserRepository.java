package com.mspprarosaje.arosaje.repositories;

import com.mspprarosaje.arosaje.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

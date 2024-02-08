package com.mspprarosaje.arosaje.repositories;

import com.mspprarosaje.arosaje.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}

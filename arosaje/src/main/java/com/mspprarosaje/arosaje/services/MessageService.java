package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    List<Message> getMessages();
    Optional<Message> getMessageById(int id);
    Message saveMessage(Message message, int senderId);
    boolean existsById(int id);
    void deleteById(int id);
}

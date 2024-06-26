package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    List<Message> getMessages();
    Optional<Message> getMessageById(int id);
    List<Message> getMessagesBetweenTwoUsers(int senderId, int receiverId);
    Message saveMessage(Message message, int senderId);
    boolean existsById(int id);
    void deleteById(int id);
    List<Message> getMessagesByUserId(int id);

	List<List<Message>> getConversations(int userId);
}

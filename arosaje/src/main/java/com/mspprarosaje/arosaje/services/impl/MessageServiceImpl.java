package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.model.Message;
import com.mspprarosaje.arosaje.repositories.MessageRepository;
import com.mspprarosaje.arosaje.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;

    @Override
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> getMessageById(int id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> getMessagesBetweenTwoUsers(int senderId, int receiverId) {
        return messageRepository.findMessagesBetweenTwoUsers(senderId, receiverId);
    }


    @Override
    public Message saveMessage(Message message, int senderId) {
        return this.messageRepository.save(message);
    }

    @Override
    public boolean existsById(int id) {
        return this.messageRepository.existsById(id);
    }

    @Override
    public void deleteById(int id) {
        this.messageRepository.deleteById(id);
    }
}

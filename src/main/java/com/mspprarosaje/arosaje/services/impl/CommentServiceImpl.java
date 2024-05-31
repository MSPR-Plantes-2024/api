package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.model.Comment;
import com.mspprarosaje.arosaje.repositories.CommentRepository;
import com.mspprarosaje.arosaje.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getCommentById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment saveComment(Comment comment, int senderId) {
        return this.commentRepository.save(comment);
    }

    @Override
    public boolean existsById(int id) {
        return this.commentRepository.existsById(id);
    }

    @Override
    public void deleteById(int id) {
        this.commentRepository.deleteById(id);
    }
}
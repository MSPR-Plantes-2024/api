package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> getComments();
    Optional<Comment> getCommentById(int id);
    Comment saveComment(Comment comment, int commentatorId);
    boolean existsById(int id);
    void deleteById(int id);
}

package com.mspprarosaje.arosaje.repositories;

import com.mspprarosaje.arosaje.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}

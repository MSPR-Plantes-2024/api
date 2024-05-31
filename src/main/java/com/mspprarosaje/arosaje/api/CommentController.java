package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.comment.CommentCreateDTO;
import com.mspprarosaje.arosaje.api.dto.comment.CommentDTO;
import com.mspprarosaje.arosaje.api.dto.comment.CommentUpdateDTO;
import com.mspprarosaje.arosaje.api.mappers.comment.CommentCreateMapper;
import com.mspprarosaje.arosaje.api.mappers.comment.CommentMapper;
import com.mspprarosaje.arosaje.api.mappers.comment.CommentUpdateMapper;
import com.mspprarosaje.arosaje.model.Comment;
import com.mspprarosaje.arosaje.services.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;
    private final CommentCreateMapper commentCreateMapper;
    private final CommentUpdateMapper commentUpdateMapper;

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getComments(){
        return ResponseEntity.ok(commentMapper.toDtos(commentService.getComments()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable("id") int id){
        return ResponseEntity.of(this.commentService.getCommentById(id).map(this.commentMapper::toDto));
    }

    @PostMapping()
    public ResponseEntity<CommentCreateDTO> saveComment(@RequestBody CommentCreateDTO commentCreateDTO){
        Comment createdComment = commentService.saveComment(
                this.commentCreateMapper.fromDto(commentCreateDTO),
                commentCreateDTO.getCommentator().getId()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(this.commentCreateMapper.toDto(createdComment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentUpdateDTO> updateComment(@PathVariable("id") Integer id,
                                                          @RequestBody CommentUpdateDTO commentUpdateDTO){
        if (!id.equals((commentUpdateDTO.getId()))){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(!this.commentService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Comment updateComment = commentService.saveComment(
                this.commentUpdateMapper.fromDto(commentUpdateDTO),
                commentUpdateDTO.getCommentator().getId()
        );
        return ResponseEntity.ok(this.commentUpdateMapper.toDto((updateComment)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable() Integer id){
        if(!this.commentService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.commentService.deleteById(id);
        if(this.commentService.existsById(id)){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

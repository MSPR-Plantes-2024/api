package com.mspprarosaje.arosaje.api.mappers.comment;

import com.mspprarosaje.arosaje.api.dto.comment.CommentDTO;
import com.mspprarosaje.arosaje.model.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment fromDto(CommentDTO commentDTO);

    List<Comment> fromDtos(List<CommentDTO> commentDto);

    CommentDTO toDto(Comment comment);

    List<CommentDTO> toDtos(List<Comment> comments);
}

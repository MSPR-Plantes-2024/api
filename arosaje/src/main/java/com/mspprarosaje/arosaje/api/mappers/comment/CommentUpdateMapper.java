package com.mspprarosaje.arosaje.api.mappers.comment;

import com.mspprarosaje.arosaje.api.dto.comment.CommentUpdateDTO;
import com.mspprarosaje.arosaje.model.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentUpdateMapper {
    //Todo : décommenter après ajout de plants
    Comment fromDto(CommentUpdateDTO commentUpdateDTO);
    List<Comment> fromDtos(List<CommentUpdateDTO> commentUpdateDto);
    CommentUpdateDTO toDto(Comment comment);
    List<CommentUpdateDTO> toDtos(List<Comment> comments);
}

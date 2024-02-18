package com.mspprarosaje.arosaje.api.mappers.comment;

import com.mspprarosaje.arosaje.api.dto.comment.CommentCreateDTO;
import com.mspprarosaje.arosaje.model.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentCreateMapper {
    //Todo : décommenter après ajout de plants
    Comment fromDto(CommentCreateDTO commentCreateDTO);
    List<Comment> fromDtos(List<CommentCreateDTO> commentCreateDto);
    CommentCreateDTO toDto(Comment comment);
    List<CommentCreateDTO> toDtos(List<Comment> comments);
}

package com.mspprarosaje.arosaje.api.mappers.comment;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.dto.comment.CommentUpdateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.Comment;
import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.model.UserType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-15T17:04:16+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class CommentUpdateMapperImpl implements CommentUpdateMapper {

    @Override
    public Comment fromDto(CommentUpdateDTO commentUpdateDTO) {
        if ( commentUpdateDTO == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setId( commentUpdateDTO.getId() );
        comment.setText( commentUpdateDTO.getText() );
        comment.setCommentator( userMinimalDTOToUser( commentUpdateDTO.getCommentator() ) );

        return comment;
    }

    @Override
    public List<Comment> fromDtos(List<CommentUpdateDTO> commentUpdateDto) {
        if ( commentUpdateDto == null ) {
            return null;
        }

        List<Comment> list = new ArrayList<Comment>( commentUpdateDto.size() );
        for ( CommentUpdateDTO commentUpdateDTO : commentUpdateDto ) {
            list.add( fromDto( commentUpdateDTO ) );
        }

        return list;
    }

    @Override
    public CommentUpdateDTO toDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentUpdateDTO.CommentUpdateDTOBuilder commentUpdateDTO = CommentUpdateDTO.builder();

        commentUpdateDTO.id( comment.getId() );
        commentUpdateDTO.text( comment.getText() );
        commentUpdateDTO.commentator( userToUserMinimalDTO( comment.getCommentator() ) );

        return commentUpdateDTO.build();
    }

    @Override
    public List<CommentUpdateDTO> toDtos(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<CommentUpdateDTO> list = new ArrayList<CommentUpdateDTO>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( toDto( comment ) );
        }

        return list;
    }

    protected UserType userTypeDTOToUserType(UserTypeDTO userTypeDTO) {
        if ( userTypeDTO == null ) {
            return null;
        }

        UserType userType = new UserType();

        userType.setId( userTypeDTO.getId() );
        userType.setName( userTypeDTO.getName() );

        return userType;
    }

    protected User userMinimalDTOToUser(UserMinimalDTO userMinimalDTO) {
        if ( userMinimalDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userMinimalDTO.getId() );
        user.setFirstName( userMinimalDTO.getFirstName() );
        user.setLastName( userMinimalDTO.getLastName() );
        user.setUserType( userTypeDTOToUserType( userMinimalDTO.getUserType() ) );

        return user;
    }

    protected UserTypeDTO userTypeToUserTypeDTO(UserType userType) {
        if ( userType == null ) {
            return null;
        }

        UserTypeDTO.UserTypeDTOBuilder userTypeDTO = UserTypeDTO.builder();

        userTypeDTO.id( userType.getId() );
        userTypeDTO.name( userType.getName() );

        return userTypeDTO.build();
    }

    protected UserMinimalDTO userToUserMinimalDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserMinimalDTO.UserMinimalDTOBuilder userMinimalDTO = UserMinimalDTO.builder();

        userMinimalDTO.id( user.getId() );
        userMinimalDTO.firstName( user.getFirstName() );
        userMinimalDTO.lastName( user.getLastName() );
        userMinimalDTO.userType( userTypeToUserTypeDTO( user.getUserType() ) );

        return userMinimalDTO.build();
    }
}

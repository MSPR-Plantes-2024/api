package com.mspprarosaje.arosaje.api.mappers.comment;

import com.mspprarosaje.arosaje.api.dto.ReportDTO;
import com.mspprarosaje.arosaje.api.dto.comment.CommentCreateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.Comment;
import com.mspprarosaje.arosaje.model.Report;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T22:23:21+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class CommentCreateMapperImpl implements CommentCreateMapper {

    @Override
    public Comment fromDto(CommentCreateDTO commentCreateDTO) {
        if ( commentCreateDTO == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setText( commentCreateDTO.getText() );
        comment.setCommentator( userMinimalDTOToUser( commentCreateDTO.getCommentator() ) );
        comment.setReport( reportDTOToReport( commentCreateDTO.getReport() ) );

        return comment;
    }

    @Override
    public List<Comment> fromDtos(List<CommentCreateDTO> commentCreateDto) {
        if ( commentCreateDto == null ) {
            return null;
        }

        List<Comment> list = new ArrayList<Comment>( commentCreateDto.size() );
        for ( CommentCreateDTO commentCreateDTO : commentCreateDto ) {
            list.add( fromDto( commentCreateDTO ) );
        }

        return list;
    }

    @Override
    public CommentCreateDTO toDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentCreateDTO.CommentCreateDTOBuilder commentCreateDTO = CommentCreateDTO.builder();

        commentCreateDTO.text( comment.getText() );
        commentCreateDTO.commentator( userToUserMinimalDTO( comment.getCommentator() ) );
        commentCreateDTO.report( reportToReportDTO( comment.getReport() ) );

        return commentCreateDTO.build();
    }

    @Override
    public List<CommentCreateDTO> toDtos(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<CommentCreateDTO> list = new ArrayList<CommentCreateDTO>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( toDto( comment ) );
        }

        return list;
    }

    protected User userMinimalDTOToUser(UserMinimalDTO userMinimalDTO) {
        if ( userMinimalDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userMinimalDTO.getId() );
        user.firstName( userMinimalDTO.getFirstName() );
        user.lastName( userMinimalDTO.getLastName() );
        user.userType( userMinimalDTO.getUserType() );

        return user.build();
    }

    protected Report reportDTOToReport(ReportDTO reportDTO) {
        if ( reportDTO == null ) {
            return null;
        }

        Report report = new Report();

        report.setId( reportDTO.getId() );
        report.setPublishingDate( reportDTO.getPublishingDate() );
        report.setPublication( reportDTO.getPublication() );
        report.setText( reportDTO.getText() );

        return report;
    }

    protected UserMinimalDTO userToUserMinimalDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserMinimalDTO.UserMinimalDTOBuilder userMinimalDTO = UserMinimalDTO.builder();

        userMinimalDTO.id( user.getId() );
        userMinimalDTO.firstName( user.getFirstName() );
        userMinimalDTO.lastName( user.getLastName() );
        userMinimalDTO.userType( user.getUserType() );

        return userMinimalDTO.build();
    }

    protected ReportDTO reportToReportDTO(Report report) {
        if ( report == null ) {
            return null;
        }

        ReportDTO.ReportDTOBuilder reportDTO = ReportDTO.builder();

        reportDTO.id( report.getId() );
        reportDTO.publishingDate( report.getPublishingDate() );
        reportDTO.text( report.getText() );
        reportDTO.publication( report.getPublication() );

        return reportDTO.build();
    }
}

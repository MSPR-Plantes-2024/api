package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.PublicationDTO;
import com.mspprarosaje.arosaje.api.dto.ReportDTO;
import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.dto.address.AddressDTO;
import com.mspprarosaje.arosaje.api.dto.comment.CommentDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.Address;
import com.mspprarosaje.arosaje.model.Comment;
import com.mspprarosaje.arosaje.model.Publication;
import com.mspprarosaje.arosaje.model.Report;
import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.model.UserType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-15T17:04:16+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class PublicationMapperImpl implements PublicationMapper {

    @Autowired
    private PlantMapper plantMapper;

    @Override
    public Publication fromDto(PublicationDTO publicationDto) {
        if ( publicationDto == null ) {
            return null;
        }

        Publication publication = new Publication();

        publication.setId( publicationDto.getId() );
        publication.setTitle( publicationDto.getTitle() );
        publication.setDescription( publicationDto.getDescription() );
        publication.setCreationDate( publicationDto.getCreationDate() );
        publication.setAddress( addressDTOToAddress( publicationDto.getAddress() ) );
        publication.setPublisher( userDTOToUser( publicationDto.getPublisher() ) );
        publication.setGardenKeeper( userDTOToUser( publicationDto.getGardenKeeper() ) );
        publication.setPlants( plantMapper.fromDtos( publicationDto.getPlants() ) );
        publication.setComments( commentDTOListToCommentList( publicationDto.getComments() ) );

        return publication;
    }

    @Override
    public List<Publication> fromDtos(List<PublicationDTO> publicationsDto) {
        if ( publicationsDto == null ) {
            return null;
        }

        List<Publication> list = new ArrayList<Publication>( publicationsDto.size() );
        for ( PublicationDTO publicationDTO : publicationsDto ) {
            list.add( fromDto( publicationDTO ) );
        }

        return list;
    }

    @Override
    public PublicationDTO toDto(Publication publicattion) {
        if ( publicattion == null ) {
            return null;
        }

        PublicationDTO.PublicationDTOBuilder publicationDTO = PublicationDTO.builder();

        publicationDTO.id( publicattion.getId() );
        publicationDTO.title( publicattion.getTitle() );
        publicationDTO.description( publicattion.getDescription() );
        publicationDTO.creationDate( publicattion.getCreationDate() );
        publicationDTO.address( addressToAddressDTO( publicattion.getAddress() ) );
        publicationDTO.publisher( userToUserDTO( publicattion.getPublisher() ) );
        publicationDTO.gardenKeeper( userToUserDTO( publicattion.getGardenKeeper() ) );
        publicationDTO.plants( plantMapper.toDtos( publicattion.getPlants() ) );
        publicationDTO.comments( commentListToCommentDTOList( publicattion.getComments() ) );

        return publicationDTO.build();
    }

    @Override
    public List<PublicationDTO> toDtos(List<Publication> publications) {
        if ( publications == null ) {
            return null;
        }

        List<PublicationDTO> list = new ArrayList<PublicationDTO>( publications.size() );
        for ( Publication publication : publications ) {
            list.add( toDto( publication ) );
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

    protected Address addressDTOToAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDTO.getId() );
        address.setPostalAddress( addressDTO.getPostalAddress() );
        address.setCity( addressDTO.getCity() );
        address.setZipCode( addressDTO.getZipCode() );
        address.setOtherInfo( addressDTO.getOtherInfo() );
        address.setUser( userMinimalDTOToUser( addressDTO.getUser() ) );

        return address;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setFirstName( userDTO.getFirstName() );
        user.setLastName( userDTO.getLastName() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( userDTO.getPassword() );
        user.setUserType( userTypeDTOToUserType( userDTO.getUserType() ) );

        return user;
    }

    protected Report reportDTOToReport(ReportDTO reportDTO) {
        if ( reportDTO == null ) {
            return null;
        }

        Report report = new Report();

        report.setId( reportDTO.getId() );
        report.setPublishingDate( reportDTO.getPublishingDate() );
        report.setText( reportDTO.getText() );

        return report;
    }

    protected Comment commentDTOToComment(CommentDTO commentDTO) {
        if ( commentDTO == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setId( commentDTO.getId() );
        comment.setText( commentDTO.getText() );
        comment.setPublishingDate( commentDTO.getPublishingDate() );
        comment.setCommentator( userMinimalDTOToUser( commentDTO.getCommentator() ) );
        comment.setReport( reportDTOToReport( commentDTO.getReport() ) );

        return comment;
    }

    protected List<Comment> commentDTOListToCommentList(List<CommentDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Comment> list1 = new ArrayList<Comment>( list.size() );
        for ( CommentDTO commentDTO : list ) {
            list1.add( commentDTOToComment( commentDTO ) );
        }

        return list1;
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

    protected AddressDTO addressToAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO.AddressDTOBuilder addressDTO = AddressDTO.builder();

        addressDTO.id( address.getId() );
        addressDTO.postalAddress( address.getPostalAddress() );
        addressDTO.city( address.getCity() );
        addressDTO.zipCode( address.getZipCode() );
        addressDTO.otherInfo( address.getOtherInfo() );
        addressDTO.user( userToUserMinimalDTO( address.getUser() ) );

        return addressDTO.build();
    }

    protected UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.id( user.getId() );
        userDTO.firstName( user.getFirstName() );
        userDTO.lastName( user.getLastName() );
        userDTO.email( user.getEmail() );
        userDTO.password( user.getPassword() );
        userDTO.userType( userTypeToUserTypeDTO( user.getUserType() ) );

        return userDTO.build();
    }

    protected ReportDTO reportToReportDTO(Report report) {
        if ( report == null ) {
            return null;
        }

        ReportDTO.ReportDTOBuilder reportDTO = ReportDTO.builder();

        reportDTO.id( report.getId() );
        reportDTO.publishingDate( report.getPublishingDate() );
        reportDTO.text( report.getText() );

        return reportDTO.build();
    }

    protected CommentDTO commentToCommentDTO(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDTO.CommentDTOBuilder commentDTO = CommentDTO.builder();

        commentDTO.id( comment.getId() );
        commentDTO.text( comment.getText() );
        commentDTO.publishingDate( comment.getPublishingDate() );
        commentDTO.commentator( userToUserMinimalDTO( comment.getCommentator() ) );
        commentDTO.report( reportToReportDTO( comment.getReport() ) );

        return commentDTO.build();
    }

    protected List<CommentDTO> commentListToCommentDTOList(List<Comment> list) {
        if ( list == null ) {
            return null;
        }

        List<CommentDTO> list1 = new ArrayList<CommentDTO>( list.size() );
        for ( Comment comment : list ) {
            list1.add( commentToCommentDTO( comment ) );
        }

        return list1;
    }
}

package com.mspprarosaje.arosaje.api.mappers.message;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.dto.message.MessageDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.Message;
import com.mspprarosaje.arosaje.model.User;

import com.mspprarosaje.arosaje.model.UserType;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-08T16:21:36+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public Message fromDto(MessageDTO messageDTO) {
        if ( messageDTO == null ) {
            return null;
        }

        Message message = new Message();

        message.setId( messageDTO.getId() );
        message.setText( messageDTO.getText() );
        message.setPublishingDate( messageDTO.getPublishingDate() );
        message.setSender( userMinimalDTOToUser( messageDTO.getSender() ) );
        message.setReceiver( userMinimalDTOToUser( messageDTO.getReceiver() ) );

        return message;
    }

    @Override
    public List<Message> fromDtos(List<MessageDTO> messageDto) {
        if ( messageDto == null ) {
            return null;
        }

        List<Message> list = new ArrayList<Message>( messageDto.size() );
        for ( MessageDTO messageDTO : messageDto ) {
            list.add( fromDto( messageDTO ) );
        }

        return list;
    }

    @Override
    public MessageDTO toDto(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageDTO.MessageDTOBuilder messageDTO = MessageDTO.builder();

        messageDTO.id( message.getId() );
        messageDTO.text( message.getText() );
        messageDTO.publishingDate( message.getPublishingDate() );
        messageDTO.sender( userToUserMinimalDTO( message.getSender() ) );
        messageDTO.receiver( userToUserMinimalDTO( message.getReceiver() ) );

        return messageDTO.build();
    }

    @Override
    public List<MessageDTO> toDtos(List<Message> messages) {
        if ( messages == null ) {
            return null;
        }

        List<MessageDTO> list = new ArrayList<MessageDTO>( messages.size() );
        for ( Message message : messages ) {
            list.add( toDto( message ) );
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

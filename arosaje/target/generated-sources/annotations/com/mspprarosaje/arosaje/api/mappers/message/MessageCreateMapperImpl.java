package com.mspprarosaje.arosaje.api.mappers.message;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.dto.message.MessageCreateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.Message;
import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.model.UserType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T10:56:33+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class MessageCreateMapperImpl implements MessageCreateMapper {

    @Override
    public Message fromDto(MessageCreateDTO messageCreateDto) {
        if ( messageCreateDto == null ) {
            return null;
        }

        Message message = new Message();

        message.setText( messageCreateDto.getText() );
        message.setSender( userMinimalDTOToUser( messageCreateDto.getSender() ) );
        message.setReceiver( userMinimalDTOToUser( messageCreateDto.getReceiver() ) );

        return message;
    }

    @Override
    public List<Message> fromDtos(List<MessageCreateDTO> messageCreateDto) {
        if ( messageCreateDto == null ) {
            return null;
        }

        List<Message> list = new ArrayList<Message>( messageCreateDto.size() );
        for ( MessageCreateDTO messageCreateDTO : messageCreateDto ) {
            list.add( fromDto( messageCreateDTO ) );
        }

        return list;
    }

    @Override
    public MessageCreateDTO toDto(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageCreateDTO.MessageCreateDTOBuilder messageCreateDTO = MessageCreateDTO.builder();

        messageCreateDTO.text( message.getText() );
        messageCreateDTO.sender( userToUserMinimalDTO( message.getSender() ) );
        messageCreateDTO.receiver( userToUserMinimalDTO( message.getReceiver() ) );

        return messageCreateDTO.build();
    }

    @Override
    public List<MessageCreateDTO> toDtos(List<Message> message) {
        if ( message == null ) {
            return null;
        }

        List<MessageCreateDTO> list = new ArrayList<MessageCreateDTO>( message.size() );
        for ( Message message1 : message ) {
            list.add( toDto( message1 ) );
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

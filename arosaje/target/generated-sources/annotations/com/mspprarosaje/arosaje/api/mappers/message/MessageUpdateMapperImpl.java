package com.mspprarosaje.arosaje.api.mappers.message;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.dto.message.MessageUpdateDTO;
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
    date = "2024-02-19T00:34:00+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class MessageUpdateMapperImpl implements MessageUpdateMapper {

    @Override
    public Message fromDto(MessageUpdateDTO messageUpdateDto) {
        if ( messageUpdateDto == null ) {
            return null;
        }

        Message message = new Message();

        message.setId( messageUpdateDto.getId() );
        message.setText( messageUpdateDto.getText() );
        message.setSender( userMinimalDTOToUser( messageUpdateDto.getSender() ) );
        message.setReceiver( userMinimalDTOToUser( messageUpdateDto.getReceiver() ) );

        return message;
    }

    @Override
    public List<Message> fromDtos(List<MessageUpdateDTO> messageUpdateDto) {
        if ( messageUpdateDto == null ) {
            return null;
        }

        List<Message> list = new ArrayList<Message>( messageUpdateDto.size() );
        for ( MessageUpdateDTO messageUpdateDTO : messageUpdateDto ) {
            list.add( fromDto( messageUpdateDTO ) );
        }

        return list;
    }

    @Override
    public MessageUpdateDTO toDto(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageUpdateDTO.MessageUpdateDTOBuilder messageUpdateDTO = MessageUpdateDTO.builder();

        messageUpdateDTO.id( message.getId() );
        messageUpdateDTO.text( message.getText() );
        messageUpdateDTO.sender( userToUserMinimalDTO( message.getSender() ) );
        messageUpdateDTO.receiver( userToUserMinimalDTO( message.getReceiver() ) );

        return messageUpdateDTO.build();
    }

    @Override
    public List<MessageUpdateDTO> toDtos(List<Message> message) {
        if ( message == null ) {
            return null;
        }

        List<MessageUpdateDTO> list = new ArrayList<MessageUpdateDTO>( message.size() );
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

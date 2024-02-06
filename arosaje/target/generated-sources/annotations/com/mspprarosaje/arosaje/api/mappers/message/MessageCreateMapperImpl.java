package com.mspprarosaje.arosaje.api.mappers.message;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.dto.message.MessageCreateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import com.mspprarosaje.arosaje.model.Message;
import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.model.UserType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-06T16:48:25+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
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
        message.setSender( userDTOToUser( messageCreateDto.getSender() ) );
        message.setReceiver( userDTOToUser( messageCreateDto.getReceiver() ) );

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
        messageCreateDTO.sender( userToUserDTO( message.getSender() ) );
        messageCreateDTO.receiver( userToUserDTO( message.getReceiver() ) );

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

    protected UserTypeDTO userTypeToUserTypeDTO(UserType userType) {
        if ( userType == null ) {
            return null;
        }

        UserTypeDTO.UserTypeDTOBuilder userTypeDTO = UserTypeDTO.builder();

        userTypeDTO.id( userType.getId() );
        userTypeDTO.name( userType.getName() );

        return userTypeDTO.build();
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
}

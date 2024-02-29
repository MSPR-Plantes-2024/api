package com.mspprarosaje.arosaje.api.mappers.message;

import com.mspprarosaje.arosaje.api.dto.message.MessageCreateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.Message;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T19:56:36+0100",
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
}

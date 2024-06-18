package com.mspprarosaje.arosaje.api.mappers.message;

import com.mspprarosaje.arosaje.api.dto.message.MessageUpdateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.Message;
import com.mspprarosaje.arosaje.model.user.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T15:25:19+0200",
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

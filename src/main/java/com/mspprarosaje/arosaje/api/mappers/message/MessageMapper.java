package com.mspprarosaje.arosaje.api.mappers.message;

import com.mspprarosaje.arosaje.api.dto.message.MessageDTO;
import com.mspprarosaje.arosaje.model.Message;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message fromDto(MessageDTO messageDTO);

    List<Message> fromDtos(List<MessageDTO> messageDto);

    MessageDTO toDto(Message message);

    List<MessageDTO> toDtos(List<Message> messages);
}

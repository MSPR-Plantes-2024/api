package com.mspprarosaje.arosaje.api.mappers.message;

import com.mspprarosaje.arosaje.api.dto.message.MessageCreateDTO;
import com.mspprarosaje.arosaje.model.Message;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageCreateMapper {
    Message fromDto(MessageCreateDTO messageCreateDto);

    List<Message> fromDtos(List<MessageCreateDTO> messageCreateDto);

    MessageCreateDTO toDto(Message message);

    List<MessageCreateDTO> toDtos(List<Message> message);
}

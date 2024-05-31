package com.mspprarosaje.arosaje.api.mappers.message;

import com.mspprarosaje.arosaje.api.dto.message.MessageUpdateDTO;
import com.mspprarosaje.arosaje.model.Message;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageUpdateMapper {
    Message fromDto(MessageUpdateDTO messageUpdateDto);

    List<Message> fromDtos(List<MessageUpdateDTO> messageUpdateDto);

    MessageUpdateDTO toDto(Message message);

    List<MessageUpdateDTO> toDtos(List<Message> message);
}

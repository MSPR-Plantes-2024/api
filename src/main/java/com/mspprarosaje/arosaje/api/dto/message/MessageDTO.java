package com.mspprarosaje.arosaje.api.dto.message;

import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MessageDTO {
    private int id;
    private String text;
    private LocalDateTime publishingDate;
    private UserMinimalDTO sender;
    private UserMinimalDTO receiver;
}

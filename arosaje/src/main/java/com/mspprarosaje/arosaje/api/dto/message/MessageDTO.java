package com.mspprarosaje.arosaje.api.dto.message;

import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MessageDTO {
    private int id;
    private String text;
    private Date publishingDate;
    private UserMinimalDTO sender;
    private UserMinimalDTO receiver;
}

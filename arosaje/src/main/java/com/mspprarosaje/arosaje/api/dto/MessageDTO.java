package com.mspprarosaje.arosaje.api.dto;

import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MessageDTO {
    private int id;
    private String text;
    private Date publishingDate;
    private UserDTO sender;
    private UserDTO receiver;
}

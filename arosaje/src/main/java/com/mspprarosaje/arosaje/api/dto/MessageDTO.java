package com.mspprarosaje.arosaje.api.dto;

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

package com.mspprarosaje.arosaje.api.dto.message;

import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageCreateDTO {
    private String text;
    private UserDTO sender;
    private UserDTO receiver;
}

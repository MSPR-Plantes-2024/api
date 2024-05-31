package com.mspprarosaje.arosaje.api.dto.message;

import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
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
    private UserMinimalDTO sender;
    private UserMinimalDTO receiver;
}

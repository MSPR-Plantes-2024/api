package com.mspprarosaje.arosaje.api.dto.publication;

import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PublicationUpdateDTO {
    private String description;
	private UserMinimalDTO gardenKeeper;
}

package com.mspprarosaje.arosaje.api.dto.publication;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PublicationUpdateDTO {
    private String description;
	private int gardenKeeperId;
}

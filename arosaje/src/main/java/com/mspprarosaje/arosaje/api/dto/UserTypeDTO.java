package com.mspprarosaje.arosaje.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTypeDTO {
	private int id;
	private String name;
}

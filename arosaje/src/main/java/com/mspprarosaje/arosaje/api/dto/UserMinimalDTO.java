package com.mspprarosaje.arosaje.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserMinimalDTO {
	private int id;
	private String firstName;
	private String lastName;
}

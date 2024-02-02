package com.mspprarosaje.arosaje.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserTypeDTO {

	private int id;
	private String name;
}

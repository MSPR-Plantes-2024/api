package com.mspprarosaje.arosaje.api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserCreateDTO {

	private String firstName;
	private String lastName;
	// private int phoneNumber;
	private String email;
	private String password;
	private int userType;
}

package com.mspprarosaje.arosaje.api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {

	private int id;
	private String firstName;
	private String lastName;
	// private int phoneNumber;
	private String email;
	private String password;
	private int userType;
}

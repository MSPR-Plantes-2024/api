package com.mspprarosaje.arosaje.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

	private int id;
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private String email;
	private String password;
	private UserTypeDTO userType;
}

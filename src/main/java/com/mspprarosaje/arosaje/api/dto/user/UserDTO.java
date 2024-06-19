package com.mspprarosaje.arosaje.api.dto.user;

import com.mspprarosaje.arosaje.model.user.UserType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private UserType userType;
}

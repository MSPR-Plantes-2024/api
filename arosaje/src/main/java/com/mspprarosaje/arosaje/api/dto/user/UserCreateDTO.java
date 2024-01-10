package com.mspprarosaje.arosaje.api.dto.user;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreateDTO {

	private String firstName;
	private String lastName;
	// private int phoneNumber;
	private String email;
	private String password;
	// private String userTypeDTO
	private String userTypeUri;
}

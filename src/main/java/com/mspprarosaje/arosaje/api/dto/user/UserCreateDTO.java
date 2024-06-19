package com.mspprarosaje.arosaje.api.dto.user;

import com.mspprarosaje.arosaje.model.user.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private UserType userType;
}

package com.mspprarosaje.arosaje.api.dto.user;

import com.mspprarosaje.arosaje.api.enumerated.UserType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAccountDTO {

	private int id;
	private String firstName;
	private String lastName;
	private UserType userType;
}

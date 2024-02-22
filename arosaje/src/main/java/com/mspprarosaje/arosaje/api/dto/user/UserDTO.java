package com.mspprarosaje.arosaje.api.dto.user;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.enumerated.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class UserDTO {

	private int id;
	private String firstName;
	private String lastName;
	//private int phoneNumber;
	private String email;
	private String password;
	//private UserTypeDTO userType;
	private UserType userType;
}

package com.mspprarosaje.arosaje.api.dto.user;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserMinimalDTO {
	private int id;
	private String firstName;
	private String lastName;
	private UserTypeDTO userType;
}

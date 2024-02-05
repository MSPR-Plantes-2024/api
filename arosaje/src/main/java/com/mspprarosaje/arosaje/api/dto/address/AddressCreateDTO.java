package com.mspprarosaje.arosaje.api.dto.address;

import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressCreateDTO {

	private String postalAddress;
	private String city;
	private String zipCode;
	private String otherInfo;
	private UserDTO user;
}

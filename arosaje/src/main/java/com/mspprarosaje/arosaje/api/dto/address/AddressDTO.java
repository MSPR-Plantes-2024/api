package com.mspprarosaje.arosaje.api.dto.address;

import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {

	private int id;
	private String postalAddress;
	private String city;
	private String zipCode;
	private String otherInfo;
	private UserMinimalDTO user;
}

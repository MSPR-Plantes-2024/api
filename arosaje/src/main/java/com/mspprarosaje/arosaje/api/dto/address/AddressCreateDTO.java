package com.mspprarosaje.arosaje.api.dto.address;

import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressCreateDTO {

	private String postalAddress;
	private String city;
	private String zipCode;
	private String otherInfo;
	private UserDTO user;
}

package com.mspprarosaje.arosaje.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {

	private int id;
	private String postalAddress;
	private String city;
	private int zipCode;
	private String otherInfo;
	private UserDTO user;
}

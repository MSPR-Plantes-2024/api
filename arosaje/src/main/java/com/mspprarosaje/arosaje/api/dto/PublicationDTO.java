package com.mspprarosaje.arosaje.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class PublicationDTO {

	private int id;
	private String title;
	private String description;
	private Date creationDate;
	private AddressDTO address;
	private UserDTO publisher;
	private UserDTO gardenKeeper;
	private List<PlantDTO> plants;
	private List<CommentDTO> comments;
}

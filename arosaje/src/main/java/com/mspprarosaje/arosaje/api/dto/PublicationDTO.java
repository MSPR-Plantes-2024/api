package com.mspprarosaje.arosaje.api.dto;

import com.mspprarosaje.arosaje.api.dto.address.AddressDTO;
import com.mspprarosaje.arosaje.api.dto.comment.CommentDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class PublicationDTO {
	//Todo : à modifier en cas de conflit avec le travail d'Alex
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

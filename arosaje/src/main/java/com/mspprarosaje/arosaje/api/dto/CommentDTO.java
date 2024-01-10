package com.mspprarosaje.arosaje.api.dto;

import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class CommentDTO {

	private int id;
	private String text;
	private Date publishingDate;
	private List<CommentDTO> answers;
	private UserDTO commentator;
	private PlantDTO plant;
}

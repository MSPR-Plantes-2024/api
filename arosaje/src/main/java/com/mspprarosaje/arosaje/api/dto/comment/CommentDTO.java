package com.mspprarosaje.arosaje.api.dto.comment;

import com.mspprarosaje.arosaje.api.dto.plant.PlantDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CommentDTO {
	private int id;
	private String text;
	private LocalDateTime publishingDate;
	private CommentDTO comment;
	private List<CommentDTO> answers;
	private UserMinimalDTO commentator;
	private PlantDTO plant;
}

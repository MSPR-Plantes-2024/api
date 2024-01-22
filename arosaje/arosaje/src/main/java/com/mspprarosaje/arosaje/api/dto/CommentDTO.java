package com.mspprarosaje.arosaje.api.dto;

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
	private UserDTO publisher;
	private List<CommentDTO> answers;
}

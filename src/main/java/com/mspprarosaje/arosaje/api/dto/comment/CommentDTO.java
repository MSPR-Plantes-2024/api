package com.mspprarosaje.arosaje.api.dto.comment;

import com.mspprarosaje.arosaje.api.dto.ReportDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CommentDTO {
	private int id;
	private String text;
	private LocalDateTime publishingDate;
	private UserMinimalDTO commentator;
	private ReportDTO report;
}

package com.mspprarosaje.arosaje.api.dto.comment;

import com.mspprarosaje.arosaje.api.dto.ReportDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentUpdateDTO {
	private int id;
	private String text;
	private UserMinimalDTO commentator;
}

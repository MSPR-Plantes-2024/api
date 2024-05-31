package com.mspprarosaje.arosaje.api.dto.report;

import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import com.mspprarosaje.arosaje.api.dto.publication.PublicationDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ReportDTO {
	private int id;
	private String title;
	private String text;
	private Date publishingDate;
	private PublicationDTO publication;
	private List<PictureDTO> pictures;
}

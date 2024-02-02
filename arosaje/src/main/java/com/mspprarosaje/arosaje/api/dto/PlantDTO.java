package com.mspprarosaje.arosaje.api.dto;

import com.mspprarosaje.arosaje.model.Picture;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlantDTO {

	private int id;
	private String name;
	private String description;
	private PictureDTO pictureDTO;
	private int user_id;


}

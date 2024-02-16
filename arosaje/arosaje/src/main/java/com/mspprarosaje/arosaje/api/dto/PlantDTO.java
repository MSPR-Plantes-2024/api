package com.mspprarosaje.arosaje.api.dto;

import com.mspprarosaje.arosaje.model.Picture;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlantDTO {

	private int id;
	private Picture picture;
	private String name;
	private String description;
	private int picture_id;
	private int user_id;


}

package com.mspprarosaje.arosaje.api.dto;

import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.model.PlantCondition;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlantDTO {

	private int id;
	private String name;
	private String description;
	private PictureDTO picture;
	private PlantConditionDTO plantCondition;
	private int user_id;

}

package com.mspprarosaje.arosaje.api.dto.plant;

import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import com.mspprarosaje.arosaje.api.dto.PlantConditionDTO;
import com.mspprarosaje.arosaje.api.dto.address.AdressMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
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
	private AdressMinimalDTO address;
	private UserMinimalDTO user;

}

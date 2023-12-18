package com.mspprarosaje.arosaje.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlantDTO {

	private int id;
	private String picture;
	private String name;
	private String description;


}

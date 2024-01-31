package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.PlantDTO;
import com.mspprarosaje.arosaje.model.Plant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlantMapper {

	//@Mapping(ignore = true, target = "picture")
	//@Mapping(ignore = true, target = "user")
	Plant fromDto(PlantDTO plantDTO);

	List<Plant> fromDtos(List<PlantDTO> plantsDTO);

	//@Mapping(source = "picture", target = "picture")
	PlantDTO toDto(Plant plant);

	List<PlantDTO> toDtos(List<Plant> plants);
}

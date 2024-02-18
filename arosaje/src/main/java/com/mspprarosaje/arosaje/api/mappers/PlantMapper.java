package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.PlantDTO;
import com.mspprarosaje.arosaje.model.Plant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlantMapper {

	@Mapping(source = "pictureDTO", target = "picture")
	Plant fromDto(PlantDTO plantDTO);

	@Mapping(source = "pictureDTO", target = "picture")
	List<Plant> fromDtos(List<PlantDTO> plantsDTO);

	@Mapping(source = "picture", target = "pictureDTO")
	PlantDTO toDto(Plant plant);

	@Mapping(source = "picture", target = "pictureDTO")
	List<PlantDTO> toDtos(List<Plant> plants);
}

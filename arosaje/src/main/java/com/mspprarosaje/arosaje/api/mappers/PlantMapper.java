package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.PlantDTO;
import com.mspprarosaje.arosaje.model.Plant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlantMapper {

	Plant fromDto(PlantDTO plantDTO);

	List<Plant> fromDtos(List<PlantDTO> plantsDTO);

	PlantDTO toDto(Plant plant);

	List<PlantDTO> toDtos(List<Plant> plants);
}



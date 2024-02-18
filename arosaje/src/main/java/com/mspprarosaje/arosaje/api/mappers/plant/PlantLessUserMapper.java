package com.mspprarosaje.arosaje.api.mappers.plant;

import com.mspprarosaje.arosaje.api.dto.plant.PlantLessUserDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantMinimalDTO;
import com.mspprarosaje.arosaje.model.Plant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlantLessUserMapper {
    Plant fromDto(PlantLessUserDTO plantLessUserDTO);

    List<Plant> fromDtos(List<PlantLessUserDTO> plantLessUserDTOS);

    PlantLessUserDTO toDto(Plant plant);

    List<PlantLessUserDTO> toDtos(List<Plant> plants);
}

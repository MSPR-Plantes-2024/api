package com.mspprarosaje.arosaje.api.mappers.plant;

import com.mspprarosaje.arosaje.api.dto.plant.PlantDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantMinimalDTO;
import com.mspprarosaje.arosaje.api.mappers.picture.PictureMapper;
import com.mspprarosaje.arosaje.model.Plant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PictureMapper.class})
public interface PlantMinimalMapper {
    Plant fromDto(PlantMinimalDTO plantMinimalDTO);

    List<Plant> fromDtos(List<PlantMinimalDTO> plantMinimalDTOS);

    PlantMinimalDTO toDto(Plant plant);

    List<PlantMinimalDTO> toDtos(List<Plant> plants);
}

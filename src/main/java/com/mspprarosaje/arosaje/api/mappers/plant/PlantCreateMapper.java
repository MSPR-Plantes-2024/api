package com.mspprarosaje.arosaje.api.mappers.plant;

import com.mspprarosaje.arosaje.api.dto.plant.PlantCreateDTO;
import com.mspprarosaje.arosaje.model.Plant;
import org.mapstruct.Mapper;

import java.util.List;

public interface PlantCreateMapper {
    Plant fromDto(PlantCreateDTO plantCreateDTO);
}

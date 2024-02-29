package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.PlantConditionDTO;
import com.mspprarosaje.arosaje.model.PlantCondition;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlantConditionMapper {

	public PlantConditionDTO toDto(PlantCondition plantCondition);
	public PlantCondition fromDto(PlantConditionDTO plantConditionDTO);
	public List<PlantConditionDTO> toDtos(List<PlantCondition> plantConditions);
	public List<PlantCondition> fromDtos(List<PlantConditionDTO> plantConditionsDTO);
}

package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Plant;
import com.mspprarosaje.arosaje.model.PlantCondition;

import java.util.List;
import java.util.Optional;

public interface PlantConditionService {
	List<PlantCondition> getPlantsConditions();
	Optional<PlantCondition> getPlantConditionById(int id);
	PlantCondition savePlantCondition(PlantCondition plantCondition);
	void deletePlantConditionById(int id);
}

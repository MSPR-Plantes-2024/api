package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Plant;
import com.mspprarosaje.arosaje.model.PlantCondition;

import java.util.List;
import java.util.Optional;

public interface PlantConditionService {

	/**
	 * Get all plants conditions
	 * @return list of plants conditions
	 */
	List<PlantCondition> getPlantsConditions();

	/**
	 * Get plant condition by id
	 * @param id plant condition id
	 * @return plant condition
	 */
	Optional<PlantCondition> getPlantConditionById(int id);

	/**
	 * Save plant condition
	 * @param plantCondition
	 * @return
	 */
	PlantCondition savePlantCondition(PlantCondition plantCondition);

	/**
	 * Delete plant condition by id
	 * @param id
	 */
	void deletePlantConditionById(int id);
}

package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Plant;

import java.util.List;
import java.util.Optional;


public interface PlantService {

	/**
	 * Get all plants
	 * @return list of plants
	 */
	List<Plant> getPlants();

	/**
	 * Get plant by id
	 * @param id plant id
	 * @return plant
	 */
	Optional<Plant> getPlantById(Integer id);

	/**
	 * Get plants by user id
	 * @param userId user id
	 * @return list of plants
	 */
	List<Plant> getPlantsByUserId(Integer userId);

	/**
	 * Get plants by address id
	 * @param addressId address id
	 * @return list of plants
	 */
	List<Plant> getPlantsByAddressId(Integer addressId);

	/**
	 * Save plant
	 * @param plant
	 * @return
	 */
 	Plant savePlant(Plant plant);

	/**
	 * Delete plant by id
	 * @param id
	 */
	void deleteById(Integer id);
}

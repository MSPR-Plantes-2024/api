package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Plant;

import java.util.List;
import java.util.Optional;


public interface PlantService {

	List<Plant> getPlants();
	Optional<Plant> getPlantById(Integer id);
	List<Plant> getPlantsByUserId(Integer userId);
 	Plant savePlant(Plant plant, int userId);
	void deleteById(Integer id);
}

package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Plant;

import java.util.List;
import java.util.Optional;


public interface PlantService {

	List<Plant> getPlants();
	Optional<Plant>  getPlantById(Integer id);
	Plant savePlant(Plant plant, int userId, int pictureId);
	void deleteById(Integer id);
}

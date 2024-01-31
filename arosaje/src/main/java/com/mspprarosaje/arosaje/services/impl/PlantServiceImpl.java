package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.api.dto.PlantDTO;
import com.mspprarosaje.arosaje.model.Plant;
import com.mspprarosaje.arosaje.repositories.PlantRepository;
import com.mspprarosaje.arosaje.services.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

	private final PlantRepository plantRepository;

	@Override
	public List<Plant> getPlants() {
		return this.plantRepository.findAll();
	}

	@Override
	public Optional<Plant> getPlantById(Integer id) {
		return this.plantRepository.findById(id);
	}

	@Override
	public List<Plant> getPlantsByUserId(Integer UserId){return this.plantRepository.findByUserId(UserId);}

	@Override
	//TODO utiliser le service User pour convertir user et picture en models
	public Plant savePlant(Plant plant, int userId, int pictureId) {
		return this.plantRepository.save(plant);
	}

	@Override
	public void deleteById(Integer id) {
		this.plantRepository.deleteById(id);
	}
}

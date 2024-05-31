package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.model.Plant;
import com.mspprarosaje.arosaje.model.PlantCondition;
import com.mspprarosaje.arosaje.repositories.PlantConditionRepository;
import com.mspprarosaje.arosaje.services.PlantConditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantConditionImpl implements PlantConditionService {

	private final PlantConditionRepository plantConditionRepository;
	@Override
	public List<PlantCondition> getPlantsConditions() {
		return this.plantConditionRepository.findAll();
	}

	@Override
	public Optional<PlantCondition> getPlantConditionById(int id) {
		return this.plantConditionRepository.findById(id);
	}

	@Override
	public PlantCondition savePlantCondition(PlantCondition plantCondition) {
		return this.plantConditionRepository.save(plantCondition);
	}

	@Override
	public void deletePlantConditionById(int id) {
		this.plantConditionRepository.deleteById(id);
	}
}

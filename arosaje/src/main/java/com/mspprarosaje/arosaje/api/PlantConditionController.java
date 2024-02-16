package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.PlantConditionDTO;
import com.mspprarosaje.arosaje.api.mappers.PlantConditionMapper;
import com.mspprarosaje.arosaje.model.PlantCondition;
import com.mspprarosaje.arosaje.services.PlantConditionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/plantsConditions")
@RequiredArgsConstructor
@Slf4j
public class PlantConditionController {

	final PlantConditionService plantConditionService;
	final PlantConditionMapper plantConditionMapper;

	@GetMapping
	public ResponseEntity<List<PlantConditionDTO>> getPlants() {
		ResponseEntity<List<PlantConditionDTO>> responseEntity;
		List<PlantCondition> plantsConditions = this.plantConditionService.getPlantsConditions();
		if(plantsConditions.isEmpty()){responseEntity = ResponseEntity.notFound().build();} else {
			responseEntity = ResponseEntity.ok(this.plantConditionMapper.toDtos(plantsConditions));
		};
		return responseEntity;
	}

	@GetMapping("/{id}")
	public ResponseEntity<PlantConditionDTO> getPlantById(@PathVariable() int id) {
		ResponseEntity<PlantConditionDTO> plantDTOResponseEntity;
		Optional<PlantCondition> plantConditionOptional = this.plantConditionService.getPlantConditionById(id);
		if(plantConditionOptional.isEmpty()){plantDTOResponseEntity = ResponseEntity.notFound().build();} else {
			plantDTOResponseEntity = ResponseEntity.ok(this.plantConditionMapper.toDto(plantConditionOptional.get()));
		};
		return plantDTOResponseEntity;
	}

	@PutMapping("/{id}")
	public ResponseEntity<PlantConditionDTO> updatePlant(@PathVariable() Integer id, @RequestBody PlantConditionDTO plantConditionDTO) {
		ResponseEntity<PlantConditionDTO> plantDTOResponseEntity;
		Optional<PlantCondition> plantOptional = this.plantConditionService.getPlantConditionById(id);
		if(plantOptional.isEmpty()){plantDTOResponseEntity = ResponseEntity.notFound().build();
		} else {
			PlantCondition plantCondition = plantOptional.get();
			plantCondition.setName(plantConditionDTO.getName());
			PlantCondition updatedPlant = this.plantConditionService.savePlantCondition(plantCondition);
			plantDTOResponseEntity = ResponseEntity.ok(this.plantConditionMapper.toDto(updatedPlant));
		};
		return plantDTOResponseEntity;
	}

	@PostMapping
	public ResponseEntity<PlantConditionDTO> createPlant(@RequestBody PlantConditionDTO plantConditionDTO) {
		ResponseEntity<PlantConditionDTO> responseEntity;

		PlantCondition plantCondition = plantConditionService.savePlantCondition(
			this.plantConditionMapper.fromDto(plantConditionDTO));

		if (plantCondition == null) {
			responseEntity = ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.build();
		} else {
			responseEntity = ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.plantConditionMapper.toDto(plantCondition));
		}
		return responseEntity;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlant(@PathVariable() int id) {
		this.plantConditionService.deletePlantConditionById(id);
		return ResponseEntity.noContent().build();
	}
}

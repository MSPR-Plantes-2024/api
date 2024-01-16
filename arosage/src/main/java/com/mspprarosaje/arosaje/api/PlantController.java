package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.PlantDTO;
import com.mspprarosaje.arosaje.api.mappers.PlantMapper;
import com.mspprarosaje.arosaje.model.Plant;
import com.mspprarosaje.arosaje.services.PlantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/plants")
@RequiredArgsConstructor
@Slf4j
public class PlantController {

	private final PlantService plantService;
	private final PlantMapper plantMapper;
	@GetMapping
	public ResponseEntity<List<PlantDTO>> getPlants() {
		return ResponseEntity.ok(this.plantMapper.toDtos(this.plantService.getPlants()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PlantDTO> getPlant(@PathVariable() Integer id) {
		Optional<Plant> plantOptional = this.plantService.getPlantById(id);
		Optional<PlantDTO> plantDTOOptional = plantOptional.map(plant -> {
			return PlantDTO.builder()
				.id(plant.getId())
				.name(plant.getName())
				.description(plant.getDescription())
				.picture(plant.getPicture())
				.build();
		});
		return ResponseEntity.of(plantDTOOptional);
	}
	@PostMapping()
	public ResponseEntity<PlantDTO> createPlant(
		@RequestBody PlantDTO plantDTO
	) {
		Plant plant = plantService.savePlant(
			this.plantMapper.fromDto(plantDTO), plantDTO.getUser_id(), plantDTO.getPicture_id()
		);

		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(this.plantMapper.toDto(plant));
	}

	@PutMapping("/{id}")
	public ResponseEntity<PlantDTO> updatePlant(
		@PathVariable() Integer id,
		@RequestBody PlantDTO plantDTO
	) {
		ResponseEntity<PlantDTO> responseEntity;

		if (!id.equals(plantDTO.getId())) {
			responseEntity = ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.build();
		} else if (this.plantService.getPlantById(id).isEmpty()) {
			responseEntity = ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.build();
		} else {
			Plant updatedPlant = plantService.savePlant(
				this.plantMapper.fromDto(plantDTO), plantDTO.getUser_id(), plantDTO.getPicture_id());
			responseEntity = ResponseEntity
				.ok(this.plantMapper.toDto(updatedPlant));
		}

		return responseEntity;
	}

	//TODO Remplacer la forêt de if par un try catch
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePower(
		@PathVariable() Integer id
	) {
		ResponseEntity<Void> responseEntity;

		if (this.plantService.getPlantById(id).isEmpty()) {
			responseEntity = ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.build();
		} else {
			this.plantService.deleteById(id);
		}

		if (this.plantService.getPlantById(id).isPresent()) {
			responseEntity = ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.build();
		} else {
			responseEntity = ResponseEntity
				.status(HttpStatus.NO_CONTENT)
				.build();
		};

		return responseEntity;
	}
}

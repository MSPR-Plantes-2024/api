package com.mspprarosaje.arosaje.api;


import com.mspprarosaje.arosaje.api.dto.plant.PlantCreateDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantLessUserDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantMinimalDTO;
import com.mspprarosaje.arosaje.api.mappers.plant.PlantCreateMapper;
import com.mspprarosaje.arosaje.api.mappers.plant.PlantLessUserMapper;
import com.mspprarosaje.arosaje.api.mappers.plant.PlantMapper;
import com.mspprarosaje.arosaje.api.mappers.plant.PlantMinimalMapper;
import com.mspprarosaje.arosaje.model.Plant;
import com.mspprarosaje.arosaje.services.PlantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
	private final PlantMinimalMapper plantMinimalMapper;
	private final PlantLessUserMapper plantLessUserMapper;
	private final PlantCreateMapper plantCreateMapper;

	/**
	 * Recovers all plants created
	 * @return List of plantDTO
	 */
	@GetMapping
	public ResponseEntity<List<PlantDTO>> getPlants() {
		ResponseEntity<List<PlantDTO>> responseEntity;
		List<Plant> plants = this.plantService.getPlants();
		if(plants.isEmpty()){responseEntity = ResponseEntity.notFound().build();} else {
			responseEntity = ResponseEntity.ok(this.plantMapper.toDtos(plants));
		};
		return responseEntity;
	}

	/**
	 * Recover the plant corresponding to the id entered in parameter
	 * @param id Plant id to be recovered
	 * @return The plant as plantDTO object
	 */
	@GetMapping("/{id}")
	public ResponseEntity<PlantDTO> getPlantById(@PathVariable() Integer id) {
		ResponseEntity<PlantDTO> plantDTOResponseEntity;
		Optional<Plant> plantOptional = this.plantService.getPlantById(id);
		if(plantOptional.isEmpty()){plantDTOResponseEntity = ResponseEntity.notFound().build();} else {
			plantDTOResponseEntity = ResponseEntity.ok(this.plantMapper.toDto(plantOptional.get()));
		};
		return plantDTOResponseEntity;
	}

	/**
	 * Retrieves the list of plants linked to a user
	 * @param userId Id of the user
	 * @return The List of plantDTO object linked with a userId
	 */
	@GetMapping("users/{userId}")
	public ResponseEntity<List<PlantLessUserDTO>> getPlantByUserId(@PathVariable() Integer userId) {
		ResponseEntity<List<PlantLessUserDTO>> responseEntity;
		List<Plant> plants = this.plantService.getPlantsByUserId(userId);
		if(plants.isEmpty()){responseEntity = ResponseEntity.notFound().build();} else {
			responseEntity = ResponseEntity.ok(this.plantLessUserMapper.toDtos(plants));
		};
		return responseEntity;
	}

	/**
	 * Retrieves the list of plants linked to an address
	 * @param addressId Id of the address
	 * @return The List of plantDTO object linked with an address id
	 */
	@GetMapping("address/{addressId}")
	public ResponseEntity<List<PlantMinimalDTO>> getPlantByAddressId(@PathVariable() Integer addressId) {
		ResponseEntity<List<PlantMinimalDTO>> responseEntity;
		List<Plant> plants = this.plantService.getPlantsByAddressId(addressId);
		if(plants.isEmpty()){responseEntity = ResponseEntity.notFound().build();} else {
			responseEntity = ResponseEntity.ok(this.plantMinimalMapper.toDtos(plants));
		};
		return responseEntity;
	}

	/***
	 * Create a plant in the database
	 * @param plantCreateDTO PlantCreateDTO object : model for creation
	 * @return plantDTO object created
	 */
	@PostMapping()
	public ResponseEntity<PlantDTO> createPlant(
		@RequestBody PlantCreateDTO plantCreateDTO
	) {
		ResponseEntity<PlantDTO> responseEntity;

		Plant plant = plantService.savePlant(
			this.plantCreateMapper.fromDto(plantCreateDTO));
		if (plant == null) {
			responseEntity = ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.build();
		} else {
			responseEntity = ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.plantMapper.toDto(plant));
		}
		return responseEntity;
	}

	/***
	 *
	 * @param id  Plant id to be updated
	 * @param plantDTO PlantDTO Object : model for updating
	 * @return The updated plant as plantDTO object
	 */
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
				this.plantMapper.fromDto(plantDTO));
			responseEntity = ResponseEntity
				.ok(this.plantMapper.toDto(updatedPlant));
		}

		return responseEntity;
	}

	/***
	 * Deletes a plant from the database according to the id entered in parameter
	 * @param id plant to delete
	 * @return ResponseEntity to describe the successful deletion
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlant(
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

package com.mspprarosaje.arosaje.plant;

import com.mspprarosaje.arosaje.AppConfig;
import com.mspprarosaje.arosaje.api.PlantController;
import com.mspprarosaje.arosaje.api.dto.plant.PlantCreateDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PlantTests {

	@Autowired
	AppConfig appConfig;

	@Autowired
	PlantController plantController;

	@Test
	void plantsRequestIsNotNull() {
		assertTrue(plantController.getPlants().getBody() != null);
	}
	@Test
	void plantResquestIsNotNull() {
		PlantDTO plantDTO = plantController.getPlantById(1).getBody();
		assertTrue(plantDTO != null);
	}
	@Test
	void plantResquestIsNull() {
		PlantDTO plantDTO = plantController.getPlantById(0).getBody();
		assertTrue(plantDTO == null);
	}

}

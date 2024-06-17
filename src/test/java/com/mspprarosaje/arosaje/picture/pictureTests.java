package com.mspprarosaje.arosaje.picture;

import com.mspprarosaje.arosaje.AppConfig;
import com.mspprarosaje.arosaje.api.PictureController;
import com.mspprarosaje.arosaje.api.PlantController;
import com.mspprarosaje.arosaje.api.dto.picture.PictureCreateDTO;
import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.services.impl.PictureStreamServiceImpl;
import jakarta.validation.constraints.AssertTrue;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class pictureTests {

	@Autowired
	AppConfig appConfig;

	@Autowired
	PictureController pictureController;

	@Autowired
	PictureStreamServiceImpl pictureStreamService;

	//TODO : Charger une base de données en mémoire pour l'exécution des tests
	// Permet de ne pas intéragir avec la base en prod
	@Test
	void pullDataOfPicture() throws IOException {
		File file = new File(appConfig.picturesPath() + 1 + ".jpg");
		byte[] data = Files.readAllBytes(file.toPath());

		PictureDTO pictureDTO = pictureController.getPictureById(1).getBody();
		byte[] dataDownload = pictureDTO.getData();
		System.out.println(data.toString());
		System.out.println(data.length);
		System.out.println(dataDownload.length);

		assertTrue(data == dataDownload);
	}
}

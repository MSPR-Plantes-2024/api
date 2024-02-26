package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.picture.PictureCreateDTO;
import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import com.mspprarosaje.arosaje.api.mappers.picture.PictureMapper;
import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.services.PictureService;
import com.mspprarosaje.arosaje.services.PictureStreamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pictures")
@RequiredArgsConstructor
@Slf4j
public class PictureController {

    private final PictureService pictureService;
    private final PictureMapper pictureMapper;
	private final PictureStreamService pictureStreamService;

	/**
	 * Get all pictures
	 * @return list of pictures
	 */
	@GetMapping
	public ResponseEntity<List<PictureDTO>> getPictures() {
		ResponseEntity<List<PictureDTO>> responseEntity;
		boolean dataIsTransfered = true ;
		List<Picture> pictures = this.pictureService.getPictures();
		if(pictures.isEmpty()){responseEntity = ResponseEntity.notFound().build();} else {
			List<PictureDTO> pictureDTOS = this.pictureMapper.toDtos(pictures);
			for (PictureDTO pictureDTO : pictureDTOS) {
				pictureDTO.setData(Arrays.toString(pictureStreamService.downloadPicture(pictureDTO.getId())));
				if (pictureDTO.getData().isEmpty()) {dataIsTransfered = false;}
			}

			if (!dataIsTransfered) {responseEntity = ResponseEntity.badRequest().build();}
			else { responseEntity = ResponseEntity.ok(pictureDTOS);}
		};
		return responseEntity;
	}

	/**
	 * Get picture by id
	 * @param id picture id
	 * @return picture
	 */
@GetMapping("/{id}")
	public ResponseEntity<PictureDTO> getPictureById(@PathVariable() Integer id) {
		ResponseEntity<PictureDTO> pictureDTOResponseEntity;
		Optional<Picture> pictureOptional = this.pictureService.getPictureById(id);
		if(pictureOptional.isEmpty()){pictureDTOResponseEntity = ResponseEntity.notFound().build();} else {
			PictureDTO pictureDTO = this.pictureMapper.toDto(pictureOptional.get());
			pictureDTO.setData(Arrays.toString(pictureStreamService.downloadPicture(pictureDTO.getId())));
			if (pictureDTO.getData() == null) {pictureDTOResponseEntity = ResponseEntity.badRequest().build();}
			else {pictureDTOResponseEntity = ResponseEntity.ok(pictureDTO);}
		};
		return pictureDTOResponseEntity;
	}

	/**
	 * Create a picture
	 * @param pictureCreateDTO picture to be created
	 * @return picture
	 */
@PostMapping
	public ResponseEntity<PictureDTO> createPicture(@RequestBody PictureCreateDTO pictureCreateDTO){
		ResponseEntity<PictureDTO> pictureDTOResponseEntity;
		Picture picture = new Picture();
		Picture pictureCreated = this.pictureService.createPicture(picture);
		if(pictureCreated == null){pictureDTOResponseEntity = ResponseEntity.badRequest().build();}
		else {
			PictureDTO pictureDTO = this.pictureMapper.toDto(pictureCreated);
			pictureDTO.setData(pictureCreateDTO.getData());
			boolean isUpload = pictureStreamService.uploadPicture(pictureDTO);
			if(!isUpload){
				pictureService.deletePicture(pictureCreated.getId());
				pictureDTOResponseEntity = ResponseEntity.badRequest().build();}
			else {pictureDTOResponseEntity = ResponseEntity.ok(pictureDTO);}
		};
		return pictureDTOResponseEntity;
	}

	/**
	 * Update picture
	 * @param id picture id
	 * @return picture
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<PictureDTO> deletePicture(@PathVariable() Integer id){
		ResponseEntity<PictureDTO> pictureDTOResponseEntity;
		Optional<Picture> pictureOptional = this.pictureService.getPictureById(id);
		if(pictureOptional.isEmpty()){pictureDTOResponseEntity = ResponseEntity.notFound().build();} else {
			PictureDTO pictureDTO = this.pictureMapper.toDto(pictureOptional.get());
			boolean isDeleted = pictureStreamService.deletePicture(pictureDTO);
			if(!isDeleted){pictureDTOResponseEntity = ResponseEntity.badRequest().build();}
			else {
				this.pictureService.deletePicture(id);
				pictureDTOResponseEntity =ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
		};
		return pictureDTOResponseEntity;
	}

}

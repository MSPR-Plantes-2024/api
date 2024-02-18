package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.PictureDTO;
import com.mspprarosaje.arosaje.api.mappers.PictureMapper;
import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.services.PictureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pictures")
@RequiredArgsConstructor
@Slf4j
public class PictureController {
	//Todo : à modifier en cas de conflit avec le travail d'Alex
    private final PictureService pictureService;
    private final PictureMapper pictureMapper;

	@GetMapping
	public ResponseEntity<List<PictureDTO>> getPictures() {
		ResponseEntity<List<PictureDTO>> responseEntity;
		List<Picture> pictures = this.pictureService.getPictures();
		if(pictures.isEmpty()){responseEntity = ResponseEntity.notFound().build();} else {
			responseEntity = ResponseEntity.ok(this.pictureMapper.toDtos(pictures));
		};
		return responseEntity;
	}

@GetMapping("/{id}")
	public ResponseEntity<PictureDTO> getPictureById(@PathVariable() Integer id) {
		ResponseEntity<PictureDTO> pictureDTOResponseEntity;
		Optional<Picture> pictureOptional = this.pictureService.getPictureById(id);
		pictureDTOResponseEntity = pictureOptional.map(picture -> ResponseEntity.ok(this.pictureMapper.toDto(picture))).orElseGet(() -> ResponseEntity.notFound().build());
		return pictureDTOResponseEntity;
	}

@PostMapping
	public ResponseEntity<PictureDTO> createPicture(@RequestBody PictureDTO pictureDTO) {
		ResponseEntity<PictureDTO> pictureDTOResponseEntity;
		Picture picture = this.pictureMapper.fromDto(pictureDTO);
		Picture pictureCreated = this.pictureService.createPicture(picture);
		if(pictureCreated == null){pictureDTOResponseEntity = ResponseEntity.badRequest().build();} else {
			pictureDTOResponseEntity = ResponseEntity.ok(this.pictureMapper.toDto(pictureCreated));
		};
		return pictureDTOResponseEntity;
	}

	@PutMapping("/{id}")
	public ResponseEntity<PictureDTO> updatePicture(@PathVariable() Integer id, @RequestBody PictureDTO pictureDTO) {
		ResponseEntity<PictureDTO> pictureDTOResponseEntity = ResponseEntity.badRequest().build();

		if(id != null && pictureDTO != null && pictureDTO.getUrl() != null){
			Picture pictureOnBase = this.pictureService.getPictureById(id).get();
			pictureDTO.setId(pictureOnBase.getId());
			pictureDTO.setCreationDate(pictureOnBase.getCreationDate());
			Picture pictureUpdated = this.pictureService.updatePicture(id, this.pictureMapper.fromDto(pictureDTO));
			if(pictureUpdated != null){
				pictureDTOResponseEntity = ResponseEntity.ok(this.pictureMapper.toDto(pictureUpdated));
			};
		}

		return pictureDTOResponseEntity;
	}
}

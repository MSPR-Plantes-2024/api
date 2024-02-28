package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.publication.PublicationCreateDTO;
import com.mspprarosaje.arosaje.api.dto.publication.PublicationDTO;
import com.mspprarosaje.arosaje.api.dto.publication.PublicationMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.publication.PublicationUpdateDTO;
import com.mspprarosaje.arosaje.api.mappers.publication.PublicationCreateMapper;
import com.mspprarosaje.arosaje.api.mappers.publication.PublicationMapper;
import com.mspprarosaje.arosaje.api.mappers.publication.PublicationMinimalMapper;
import com.mspprarosaje.arosaje.model.Publication;
import com.mspprarosaje.arosaje.services.PublicationService;
import com.mspprarosaje.arosaje.services.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publications")
@RequiredArgsConstructor
@Slf4j
public class PublicationController {

    final PublicationService publicationService;
	final UserService userService;

    @Autowired
    final PublicationCreateMapper publicationCreateMapper;
    final PublicationMapper publicationMapper;
    final PublicationMinimalMapper publicationMinimalMapper;

	/**
	 * Get all publications
	 * @return list of publications
	 */
	@ApiOperation(value = "Get all users", notes = "Retrieves the list of all users.")
    @GetMapping
    public ResponseEntity<List<PublicationDTO>> getPublications() {
        ResponseEntity<List<PublicationDTO>> responseEntity;
        List<Publication> publications = this.publicationService.getPublications();
        if(publications.isEmpty()){responseEntity = ResponseEntity.notFound().build();} else {
            responseEntity = ResponseEntity.ok(this.publicationMapper.toDtos(publications));
        };
        return responseEntity;
    }

	/**
	 * Get publication by id
	 * @param id publication id
	 * @return publication
	 */
    @GetMapping("/{id}")
    public ResponseEntity<PublicationMinimalDTO> getPublicationById(@PathVariable() Integer id) {
        ResponseEntity<PublicationMinimalDTO> publicationDTOResponseEntity;
        Publication publication = this.publicationService.getPublicationById(id);
        if(publication == null){publicationDTOResponseEntity = ResponseEntity.notFound().build();} else {
            publicationDTOResponseEntity = ResponseEntity.ok(this.publicationMinimalMapper.toDto(publication));
        };
        return publicationDTOResponseEntity;
    }

	/**
	 * Get all publications by user id
	 * @param id user id
	 * @return list of publications
	 */
	@GetMapping("/users/{id}")
	public ResponseEntity<List<PublicationDTO>> getPublicationsByUserId(@PathVariable() Integer id) {
		ResponseEntity<List<PublicationDTO>> responseEntity;
		List<Publication> publications = this.publicationService.getPublicationsByUserId(id);
		if(publications.isEmpty()){responseEntity = ResponseEntity.notFound().build();} else {
			responseEntity = ResponseEntity.ok(this.publicationMapper.toDtos(publications));
		};
		return responseEntity;
	}

	/**
	 * Update publication
	 * @param id publication id
	 * @param publicationUpdateDTO publication update dto
	 * @return updated publication
	 */
	@PutMapping("/{id}")
	public ResponseEntity<PublicationDTO> updatePublication(
			@PathVariable() Integer id,
			@RequestBody PublicationUpdateDTO publicationUpdateDTO
	) {
		ResponseEntity<PublicationDTO> responseEntity;
		Publication publication = this.publicationService.getPublicationById(id);
		if (publication == null || publicationUpdateDTO == null ) {
			responseEntity = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.build();
		} else {
			publication.setDescription(publicationUpdateDTO.getDescription());
			if (publicationUpdateDTO.getGardenKeeperId() != 0) {
				publication.setGardenKeeper(userService.getUserAccountById(publicationUpdateDTO.getGardenKeeperId()).get());
			}
			publication = this.publicationService.savePublication(publication);
			responseEntity = ResponseEntity
					.status(HttpStatus.OK)
					.body(this.publicationMapper.toDto(publication));
		}
		return responseEntity;
	}

	/**
	 * Create publication
	 * @param publicationCreateDTO publication create dto
	 * @return created publication
	 */
	@PostMapping()
	public ResponseEntity<PublicationDTO> createPublication(
			@RequestBody PublicationCreateDTO publicationCreateDTO
	) {
		ResponseEntity<PublicationDTO> responseEntity;

		Publication publication = publicationService.savePublication(
				this.publicationCreateMapper.fromDto(publicationCreateDTO));

		if (publication == null) {
			responseEntity = ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
		} else {
			responseEntity = ResponseEntity
					.status(HttpStatus.CREATED)
					.body(this.publicationMapper.toDto(publication));
		}
		return responseEntity;
	}

	/**
	 * Delete publication
	 * @param id publication id
	 * @return response entity
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePublication(@PathVariable() Integer id) {
		ResponseEntity<Void> responseEntity;

		if (this.publicationService.getPublicationById(id) == null) {
			responseEntity = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.build();
		} else {
			this.publicationService.deleteById(id);
		}

		if (this.publicationService.getPublicationById(id) != null) {
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

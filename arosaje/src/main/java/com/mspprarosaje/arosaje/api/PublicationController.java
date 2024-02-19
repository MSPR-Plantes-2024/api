package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.plant.PlantDTO;
import com.mspprarosaje.arosaje.api.dto.publication.PublicationCreateDTO;
import com.mspprarosaje.arosaje.api.dto.publication.PublicationDTO;
import com.mspprarosaje.arosaje.api.dto.publication.PublicationMinimalDTO;
import com.mspprarosaje.arosaje.api.mappers.publication.PublicationCreateMapper;
import com.mspprarosaje.arosaje.api.mappers.publication.PublicationMapper;
import com.mspprarosaje.arosaje.api.mappers.publication.PublicationMinimalMapper;
import com.mspprarosaje.arosaje.model.Plant;
import com.mspprarosaje.arosaje.model.Publication;
import com.mspprarosaje.arosaje.services.PublicationService;
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

    @Autowired
    final PublicationCreateMapper publicationCreateMapper;
    final PublicationService publicationService;
    final PublicationMapper publicationMapper;
    final PublicationMinimalMapper publicationMinimalMapper;

    @GetMapping
    public ResponseEntity<List<PublicationDTO>> getPublications() {
        ResponseEntity<List<PublicationDTO>> responseEntity;
        List<Publication> publications = this.publicationService.getPublications();
        if(publications.isEmpty()){responseEntity = ResponseEntity.notFound().build();} else {
            responseEntity = ResponseEntity.ok(this.publicationMapper.toDtos(publications));
        };
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicationMinimalDTO> getPublicationById(@PathVariable() Integer id) {
        ResponseEntity<PublicationMinimalDTO> publicationDTOResponseEntity;
        Publication publication = this.publicationService.getPublicationById(id);
        if(publication == null){publicationDTOResponseEntity = ResponseEntity.notFound().build();} else {
            publicationDTOResponseEntity = ResponseEntity.ok(this.publicationMinimalMapper.toDto(publication));
        };
        return publicationDTOResponseEntity;
    }

    @PostMapping()
    public ResponseEntity<PublicationDTO> createPlant(
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

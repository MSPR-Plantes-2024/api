package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.publication.PublicationCreateDTO;
import com.mspprarosaje.arosaje.api.dto.publication.PublicationDTO;
import com.mspprarosaje.arosaje.api.mappers.publication.PublicationCreateMapper;
import com.mspprarosaje.arosaje.api.mappers.publication.PublicationMapper;
import com.mspprarosaje.arosaje.model.Publication;
import com.mspprarosaje.arosaje.services.PublicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/publications")
@RequiredArgsConstructor
@Slf4j
public class PublicationController {

    final PublicationService publicationService;
    @Autowired
    final PublicationCreateMapper publicationCreateMapper;
    final PublicationMapper publicationMapper;

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

}

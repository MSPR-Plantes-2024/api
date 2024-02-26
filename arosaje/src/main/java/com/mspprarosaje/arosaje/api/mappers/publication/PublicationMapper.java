package com.mspprarosaje.arosaje.api.mappers.publication;

import com.mspprarosaje.arosaje.api.dto.publication.PublicationDTO;
import com.mspprarosaje.arosaje.model.Publication;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublicationMapper {

    Publication fromDto(PublicationDTO publicationDTO);

    List<Publication> fromDtos(List<PublicationDTO> publicationDTOS);

    PublicationDTO toDto(Publication publication);

    List<PublicationDTO> toDtos(List<Publication> publications);
}

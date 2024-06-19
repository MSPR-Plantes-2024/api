package com.mspprarosaje.arosaje.api.mappers.publication;

import com.mspprarosaje.arosaje.api.dto.publication.PublicationMinimalDTO;
import com.mspprarosaje.arosaje.api.mappers.picture.PictureMapper;
import com.mspprarosaje.arosaje.model.Publication;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PictureMapper.class})
public interface PublicationMinimalMapper {
    Publication fromDto(PublicationMinimalDTO publicationMinimalDTO);

    List<Publication> fromDtos(List<PublicationMinimalDTO> publicationMinimalDTOS);

    PublicationMinimalDTO toDto(Publication publication);

    List<PublicationMinimalDTO> toDtos(List<Publication> publications);
}

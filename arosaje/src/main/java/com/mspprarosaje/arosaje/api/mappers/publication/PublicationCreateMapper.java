package com.mspprarosaje.arosaje.api.mappers.publication;

import com.mspprarosaje.arosaje.api.dto.publication.PublicationCreateDTO;
import com.mspprarosaje.arosaje.model.Publication;

public interface PublicationCreateMapper {
    Publication fromDto(PublicationCreateDTO publicationCreateDTO);
}

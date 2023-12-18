package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.PublicationDTO;
import com.mspprarosaje.arosaje.model.Publication;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublicationMapper {
		Publication fromDto(PublicationDTO publicationDto);

		List<Publication> fromDtos(List<PublicationDTO> publicationsDto);

	PublicationDTO toDto(Publication publicattion);

		List<PublicationDTO> toDtos(List<Publication> publications);
	}

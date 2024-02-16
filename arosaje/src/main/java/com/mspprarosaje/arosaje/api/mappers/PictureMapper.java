package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.PictureDTO;
import com.mspprarosaje.arosaje.model.Picture;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PictureMapper {

    Picture fromDto(PictureDTO pictureDTO);

    List<Picture> fromDtos(List<PictureDTO> picturesDTO);

    PictureDTO toDto(Picture picture);

    List<PictureDTO> toDtos(List<Picture> pictures);
}

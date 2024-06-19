package com.mspprarosaje.arosaje.api.mappers.picture;

import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.services.PictureStreamService;
import com.mspprarosaje.arosaje.services.impl.PictureStreamServiceImpl;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

public interface PictureMapper {

    Picture fromDto(PictureDTO pictureDTO);

    List<Picture> fromDtos(List<PictureDTO> picturesDTO);

    PictureDTO toDto(Picture picture);

    List<PictureDTO> toDtos(List<Picture> pictures);
}

package com.mspprarosaje.arosaje.api.mappers.picture.Impl;

import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import com.mspprarosaje.arosaje.api.mappers.picture.PictureMapper;
import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.services.PictureStreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class PictureMapperImpl implements PictureMapper {
	final PictureStreamService pictureStreamService;
	@Override
	public Picture fromDto(PictureDTO pictureDTO) {
		Picture picture = new Picture();
		if(pictureDTO.getId() != 0){picture.setId(pictureDTO.getId());}
		if(pictureDTO.getCreationDate() != null){picture.setCreationDate(pictureDTO.getCreationDate());}
		return picture;
	}

	@Override
	public List<Picture> fromDtos(List<PictureDTO> picturesDTO) {
		List<Picture> pictures = new ArrayList<>();
		for(PictureDTO pictureDto : picturesDTO){
			pictures.add(this.fromDto(pictureDto));
		}
		return pictures;
	}

	@Override
	public PictureDTO toDto(Picture picture) {
		PictureDTO pictureDTO = new PictureDTO();
		if(picture.getId() != 0){
			pictureDTO.setId(picture.getId());
			pictureDTO.setData(this.pictureStreamService.downloadPicture(picture.getId()));
		}
		if(picture.getCreationDate() != null){pictureDTO.setCreationDate(picture.getCreationDate());}
		return pictureDTO;
	}

	@Override
	public List<PictureDTO> toDtos(List<Picture> pictures) {
		List<PictureDTO> picturesDTOS = new ArrayList<>();
		for(Picture picture : pictures){
			picturesDTOS.add(this.toDto(picture));
		}
		return picturesDTOS;
	}
}

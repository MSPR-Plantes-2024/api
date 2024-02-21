package com.mspprarosaje.arosaje.api.dto.report;

import com.mspprarosaje.arosaje.api.PictureController;
import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ReportCreateDTO {
	PictureController pictureController;

	private String title;
	private String text;
	private Integer publication_id;
	private List<Integer> pictures_id;

	public List<PictureDTO> mapPictures_idToPictures() {
		List<PictureDTO> pictures = null;

		for (Integer picture_id : pictures_id) {
			PictureDTO picture = pictureController.getPictureById(picture_id).getBody();
			pictures.add(picture);
		}

		return pictures;
	}
}

package com.mspprarosaje.arosaje.api.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class PictureDTO {
    private int id;
    private String url;
    private Date creationDate;
	private String pictureData;
}

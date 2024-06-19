package com.mspprarosaje.arosaje.api.dto.picture;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PictureDTO {
    private int id;
    private Date creationDate;
	private byte[] data;
}

package com.mspprarosaje.arosaje.api.dto.picture;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PictureCreateDTO {
	private byte[] data;
}

package com.mspprarosaje.arosaje.api.dto.plant;

import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlantCreateDTO {
    private String name;
    private String description;
    private PictureDTO picture;
    private int plantConditionId;
    private int addressId;
    private int userId;
}

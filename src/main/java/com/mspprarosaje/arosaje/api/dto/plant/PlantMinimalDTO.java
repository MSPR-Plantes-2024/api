package com.mspprarosaje.arosaje.api.dto.plant;

import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import com.mspprarosaje.arosaje.api.dto.PlantConditionDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlantMinimalDTO {
    private int id;
    private String name;
    private String description;
    private PictureDTO picture;
    private PlantConditionDTO plantCondition;
}

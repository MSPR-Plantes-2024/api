package com.mspprarosaje.arosaje.api.dto.plant;

import com.mspprarosaje.arosaje.api.dto.PictureDTO;
import com.mspprarosaje.arosaje.api.dto.PlantConditionDTO;
import com.mspprarosaje.arosaje.api.dto.address.AdressMinimalDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlantLessUserDTO {
    private int id;
    private String name;
    private String description;
    private PictureDTO picture;
    private PlantConditionDTO plantCondition;
    private AdressMinimalDTO address;
}

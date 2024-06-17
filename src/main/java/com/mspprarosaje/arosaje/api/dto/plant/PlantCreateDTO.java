package com.mspprarosaje.arosaje.api.dto.plant;

import com.mspprarosaje.arosaje.api.dto.address.AdressMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.PlantCondition;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlantCreateDTO {
    private String name;
    private String description;
    private PictureDTO picture;
    private PlantCondition plantCondition;
    private AdressMinimalDTO address;
    private UserMinimalDTO user;
}

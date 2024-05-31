package com.mspprarosaje.arosaje.api.dto.publication;

import com.mspprarosaje.arosaje.api.dto.address.AddressDTO;
import com.mspprarosaje.arosaje.api.dto.address.AdressMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserAccountDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PublicationCreateDTO {

    private String description;
    private Integer addressId;
    private Integer publisherId;
    private List<Integer> plantsId;
}

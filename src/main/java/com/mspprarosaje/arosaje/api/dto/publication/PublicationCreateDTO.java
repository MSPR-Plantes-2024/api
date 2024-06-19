package com.mspprarosaje.arosaje.api.dto.publication;

import com.mspprarosaje.arosaje.api.dto.address.AddressDTO;
import com.mspprarosaje.arosaje.api.dto.address.AdressMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserAccountDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class PublicationCreateDTO {

    private String description;
    private AddressDTO address;
    private UserMinimalDTO publisher;
    private List<PlantDTO> plants;
	private Date startingDate;
	private Date endingDate;
}

package com.mspprarosaje.arosaje.api.dto.publication;

import com.mspprarosaje.arosaje.api.dto.address.AddressDTO;
import com.mspprarosaje.arosaje.api.dto.address.AdressMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.report.ReportDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserAccountDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class PublicationDTO {
    private int id;
    private Date creationDate;
    private String description;
    private AdressMinimalDTO address;
    private UserAccountDTO publisher;
    private UserAccountDTO gardenKeeper;
    private List<PlantMinimalDTO> plants;
    private List<ReportDTO> reports;
}

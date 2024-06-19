package com.mspprarosaje.arosaje.api.dto.publication;

import com.mspprarosaje.arosaje.api.dto.address.AdressMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.report.ReportDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserAccountDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class PublicationMinimalDTO {
    private int id;
    private Date creationDate;
	private Date startingDate;
	private Date endingDate;
    private String description;
    private AdressMinimalDTO address;
    private UserAccountDTO gardenKeeper;
    private List<PlantMinimalDTO> plants;
    private List<ReportDTO> reports;
}

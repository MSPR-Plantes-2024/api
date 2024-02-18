package com.mspprarosaje.arosaje.api.dto;

import com.mspprarosaje.arosaje.model.Publication;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReportDTO {
    //Todo : à modifier en cas de conflit avec le travail d'Alex
    private int id;
    private Date publishingDate;
    private String text;
    private Publication publication;
    //private int publication_id;
}

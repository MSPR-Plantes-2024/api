package com.mspprarosaje.arosaje.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PictureDTO {
    private int id;
    private String url;
    private Date creationDate ;
}

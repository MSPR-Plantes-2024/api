package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.ReportDTO;
import com.mspprarosaje.arosaje.model.Report;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReportMapper {
    //Todo : à modifier en cas de conflit avec le travail d'Alex
    Report fromDto(ReportDTO reportDTO);
    List<Report> fromDtos(List<ReportDTO> reportDto);
    ReportDTO toDto(Report report);
    List<ReportDTO> toDtos(List<Report> reports);
}

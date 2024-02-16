package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.PictureController;
import com.mspprarosaje.arosaje.api.dto.report.ReportCreateDTO;
import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.services.PictureService;
import com.mspprarosaje.arosaje.services.impl.PictureServiceImpl;
import org.mapstruct.Mapper;
import com.mspprarosaje.arosaje.api.dto.report.ReportDTO;
import com.mspprarosaje.arosaje.model.Report;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReportMapper {

	Report fromDto(ReportDTO reportDto);

	List<Report> fromDtos(List<ReportDTO> reportsDto);

	ReportDTO toDto(Report report);

	List<ReportDTO> toDtos(List<Report> reports);

}

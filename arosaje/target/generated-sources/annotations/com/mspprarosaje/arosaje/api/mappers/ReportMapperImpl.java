package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.ReportDTO;
import com.mspprarosaje.arosaje.model.Report;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-19T00:34:00+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class ReportMapperImpl implements ReportMapper {

    @Override
    public Report fromDto(ReportDTO reportDTO) {
        if ( reportDTO == null ) {
            return null;
        }

        Report report = new Report();

        report.setId( reportDTO.getId() );
        report.setPublishingDate( reportDTO.getPublishingDate() );
        report.setPublication( reportDTO.getPublication() );
        report.setText( reportDTO.getText() );

        return report;
    }

    @Override
    public List<Report> fromDtos(List<ReportDTO> reportDto) {
        if ( reportDto == null ) {
            return null;
        }

        List<Report> list = new ArrayList<Report>( reportDto.size() );
        for ( ReportDTO reportDTO : reportDto ) {
            list.add( fromDto( reportDTO ) );
        }

        return list;
    }

    @Override
    public ReportDTO toDto(Report report) {
        if ( report == null ) {
            return null;
        }

        ReportDTO.ReportDTOBuilder reportDTO = ReportDTO.builder();

        reportDTO.id( report.getId() );
        reportDTO.publishingDate( report.getPublishingDate() );
        reportDTO.text( report.getText() );
        reportDTO.publication( report.getPublication() );

        return reportDTO.build();
    }

    @Override
    public List<ReportDTO> toDtos(List<Report> reports) {
        if ( reports == null ) {
            return null;
        }

        List<ReportDTO> list = new ArrayList<ReportDTO>( reports.size() );
        for ( Report report : reports ) {
            list.add( toDto( report ) );
        }

        return list;
    }
}

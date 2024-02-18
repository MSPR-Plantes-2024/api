package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.ReportDTO;
import com.mspprarosaje.arosaje.api.mappers.ReportMapper;
import com.mspprarosaje.arosaje.services.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
@Slf4j
public class ReportController {
    //Todo : à modifier en cas de conflit avec le travail d'Alex
    private final ReportService reportService;
    private final ReportMapper reportMapper;

    @GetMapping
    public ResponseEntity<List<ReportDTO>> getReports(){
        return ResponseEntity.ok(reportMapper.toDtos(reportService.getReports()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportDTO> getReportById(@PathVariable("id") int id){
        return ResponseEntity.of(this.reportService.getReportById(id).map(this.reportMapper::toDto));
    }
}

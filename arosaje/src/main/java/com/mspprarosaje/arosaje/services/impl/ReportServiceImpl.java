package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.model.Report;
import com.mspprarosaje.arosaje.repositories.ReportRepository;
import com.mspprarosaje.arosaje.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    //Todo : à modifier en cas de conflit avec le travail d'Alex
    private final ReportRepository reportRepository;
    @Override
    public List<Report> getReports(){
        return reportRepository.findAll();
    }

    @Override
    public Optional<Report> getReportById(int id){
        return reportRepository.findById(id);
    }
}

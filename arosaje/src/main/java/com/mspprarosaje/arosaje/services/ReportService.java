package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {
    //Todo : à modifier en cas de conflit avec le travail d'Alex
    List<Report> getReports();
    Optional<Report> getReportById(int id);
}

package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {
	Optional<Report> getReportById(Integer id);
	List<Report> getReports();
	Report saveReport(Report report);
	void deleteById(Integer id);
}

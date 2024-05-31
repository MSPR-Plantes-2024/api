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
public class ReportServiceImpl implements ReportService{

	private final ReportRepository reportRepository;
	@Override
	public Optional<Report> getReportById(Integer id) {
		return this.reportRepository.findById(id);
	}

	@Override
	public List<Report> getReports() {
		return this.reportRepository.findAll();
	}

	@Override
	public Report saveReport(Report report) {
		return this.reportRepository.save(report);
	}

	@Override
	public void deleteById(Integer id) {
		this.reportRepository.deleteById(id);
	}
}

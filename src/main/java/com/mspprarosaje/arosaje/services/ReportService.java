package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {

	/**
	 * Get report by id
	 * @param id report id
	 * @return report
	 */
	Optional<Report> getReportById(Integer id);

	/**
	 * Get all reports
	 * @return list of reports
	 */
	List<Report> getReports();

	/**
	 * Save report
	 * @param report
	 * @return
	 */
	Report saveReport(Report report);

	/**
	 * Delete report by id
	 * @param id
	 */
	void deleteById(Integer id);
}

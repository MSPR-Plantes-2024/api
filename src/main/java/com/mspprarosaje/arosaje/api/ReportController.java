package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.report.ReportCreateDTO;
import com.mspprarosaje.arosaje.api.mappers.ReportMapper;
import com.mspprarosaje.arosaje.api.dto.report.ReportDTO;
import com.mspprarosaje.arosaje.model.Report;
import com.mspprarosaje.arosaje.services.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
@Slf4j
public class ReportController {

	private final ReportService reportService;
	private final ReportMapper reportMapper;

	/**
	 * Get all reports
	 * @return list of reports
	 */
	@GetMapping
	public ResponseEntity<List<ReportDTO>> getReports() {
		ResponseEntity<List<ReportDTO>> responseEntity;
		List<Report> reports = this.reportService.getReports();
		if(reports.isEmpty()){responseEntity = ResponseEntity.notFound().build();} else {
			responseEntity = ResponseEntity.ok(this.reportMapper.toDtos(reports));
		};
		return responseEntity;
	}

	/**
	 * Get report by id
	 * @param id report id
	 * @return report
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ReportDTO> getReportById(@PathVariable() Integer id) {
		ResponseEntity<ReportDTO> reportDTOResponseEntity;
		Optional<Report> reportOptional = this.reportService.getReportById(id);
		if(reportOptional.isEmpty()){reportDTOResponseEntity = ResponseEntity.notFound().build();} else {
			reportDTOResponseEntity = ResponseEntity.ok(this.reportMapper.toDto(reportOptional.get()));
		};
		return reportDTOResponseEntity;
	}

	/**
	 * Create a report
	 * @param reportDTO report to be created
	 * @return report
	 */
	@PostMapping()
	public ResponseEntity<ReportDTO> createReport(
		@RequestBody ReportDTO reportDTO
	) {
		ResponseEntity<ReportDTO> responseEntity;

		Report report = reportService.saveReport(
			this.reportMapper.fromDto(reportDTO));

		if (report == null) {
			responseEntity = ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.build();
		} else {
			responseEntity = ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.reportMapper.toDto(report));
		}
		return responseEntity;
	}

	/**
	 * Update report
	 * @param id report id
	 * @param reportDTO report to be updated
	 * @return updated report
	 */
	@PutMapping("/{id}")
	public ResponseEntity<ReportDTO> updateReport(
		@PathVariable() Integer id,
		@RequestBody ReportDTO reportDTO
	) {
		ResponseEntity<ReportDTO> responseEntity;

		if (!id.equals(reportDTO.getId())) {
			responseEntity = ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.build();
		} else if (this.reportService.getReportById(id).isEmpty()) {
			responseEntity = ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.build();
		} else {
			Report updatedReport = reportService.saveReport(
				this.reportMapper.fromDto(reportDTO));
			responseEntity = ResponseEntity
				.ok(this.reportMapper.toDto(updatedReport));
		}

		return responseEntity;
	}


	/**
	 * Delete report
	 * @param id report id
	 * @return response entity
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReport(
		@PathVariable() Integer id
	) {
		ResponseEntity<Void> responseEntity;

		if (this.reportService.getReportById(id).isEmpty()) {
			responseEntity = ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.build();
		} else {
			this.reportService.deleteById(id);
		}

		if (this.reportService.getReportById(id).isPresent()) {
			responseEntity = ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.build();
		} else {
			responseEntity = ResponseEntity
				.status(HttpStatus.NO_CONTENT)
				.build();
		};

		return responseEntity;
	}
}

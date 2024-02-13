package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
>>>>>>> d57c749431aac5314a673e02a1b1f39439194e97
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SalePeriodReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryReportDTO;
=======
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
>>>>>>> d57c749431aac5314a673e02a1b1f39439194e97
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
<<<<<<< HEAD
	public ResponseEntity<Page<SalePeriodReportDTO>> getReport(
			@RequestParam(name = "minDate", defaultValue = "") String minDate,
			@RequestParam(name = "maxDate", defaultValue = "") String maxDate,
			@RequestParam(name = "name", defaultValue = "") String name, 
			Pageable pageable) {
		Page<SalePeriodReportDTO> dto = service.searchSaleForPeriodAndSellerName(minDate, maxDate, name, pageable);
		return ResponseEntity.ok(dto);
	}
	@GetMapping(value = "/summary")
	public ResponseEntity<Page<SaleSummaryReportDTO>> getSummary(
			@RequestParam(name = "minDate", defaultValue = "") String minDate,
			@RequestParam(name = "maxDate", defaultValue = "") String maxDate,
			Pageable pageable) {
		Page<SaleSummaryReportDTO> dto = service.searchSaleSummaryForPeriod(minDate, maxDate, pageable);
		return ResponseEntity.ok(dto);
	}

=======
	public ResponseEntity<?> getReport() {
		// TODO
		return null;
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<?> getSummary() {
		// TODO
		return null;
	}
>>>>>>> d57c749431aac5314a673e02a1b1f39439194e97
}

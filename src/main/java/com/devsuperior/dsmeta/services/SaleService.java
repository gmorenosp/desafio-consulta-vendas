package com.devsuperior.dsmeta.services;

<<<<<<< HEAD
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SalePeriodReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryReportDTO;
=======
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
>>>>>>> d57c749431aac5314a673e02a1b1f39439194e97
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
<<<<<<< HEAD
	
	@Transactional(readOnly = true)
	public Page<SalePeriodReportDTO> searchSaleForPeriodAndSellerName(String minDate, String maxDate, String name, Pageable pageable) {
		LocalDate startDate, endDate;

		startDate = getDateConverted(minDate, maxDate, false);
		endDate = getDateConverted(minDate, maxDate, true);
		Page<SalePeriodReportDTO> result = repository.searchSaleForPeriodAndSellerName(startDate, endDate, name, pageable);

		return result;
	}
	
	@Transactional(readOnly = true)
	public Page<SaleSummaryReportDTO> searchSaleSummaryForPeriod(String minDate, String maxDate, Pageable pageable) {
		LocalDate startDate, endDate;

		startDate = getDateConverted(minDate, maxDate, false);
		endDate = getDateConverted(minDate, maxDate, true);
		Page<SaleSummaryReportDTO> result = repository.searchSaleSummaryForPeriod(startDate, endDate, pageable);
		
		return result;
	}
	
	

	private LocalDate getDateConverted(String minDate, String maxDate, boolean returnMaxDate) {
		LocalDate endDate;

		if (maxDate.equals(""))
			endDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		else
			endDate = LocalDate.parse(maxDate);
		
		if (returnMaxDate) return endDate;
		
		LocalDate startDate;
		
		if (minDate.equals(""))
			startDate = endDate.minusYears(1L);
		else
			startDate = LocalDate.parse(minDate);
		
		return startDate;
	}

=======
>>>>>>> d57c749431aac5314a673e02a1b1f39439194e97
}

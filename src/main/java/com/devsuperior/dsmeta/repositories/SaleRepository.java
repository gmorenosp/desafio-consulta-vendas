package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.dto.SalePeriodReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryReportDTO;
import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("select s from Sale s where s.date between :startDate and :endDate and upper(s.seller.name) like concat('%', upper(:name), '%')")
	Page<SalePeriodReportDTO> searchSaleForPeriodAndSellerName(LocalDate startDate, LocalDate endDate, String name,
			Pageable pageable);
	
	@Query("select new com.devsuperior.dsmeta.dto.SaleSummaryReportDTO(s.seller.name, sum(s.amount)) from Sale s where s.date between :startDate and :endDate group by s.seller.name")
	Page<SaleSummaryReportDTO> searchSaleSummaryForPeriod(LocalDate startDate, LocalDate endDate, Pageable pageable);

}

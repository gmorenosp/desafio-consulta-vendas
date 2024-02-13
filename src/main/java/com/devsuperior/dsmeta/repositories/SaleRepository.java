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
	@Query("SELECT obj "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :startDate "
			+ "AND :endDate "
			+ "AND UPPER(obj.seller.name) LIKE CONCAT('%', UPPER(:name), '%')")
	Page<SalePeriodReportDTO> searchSaleForPeriodAndSellerName(LocalDate startDate, LocalDate endDate, String name,
			Pageable pageable);
	
	@Query("SELECT new com.devsuperior.dsmeta.dto.SaleSummaryReportDTO(obj.seller.name, SUM(obj.amount)) "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :startDate "
			+ "AND :endDate "
			+ "GROUP BY obj.seller.name")
	Page<SaleSummaryReportDTO> searchSaleSummaryForPeriod(LocalDate startDate, LocalDate endDate, Pageable pageable);
	
	
}
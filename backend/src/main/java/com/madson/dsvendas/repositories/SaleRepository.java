package com.madson.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.madson.dsvendas.entities.Sale;
import com.madson.dsvendas.entities.SaleSuccessDTO;
import com.madson.dsvendas.entities.SaleSumDTO;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.madson.dsvendas.entities.SaleSumDTO(obj.seller,SUM(obj.amount)) FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupBySeller();
	
	@Query("SELECT new com.madson.dsvendas.entities.SaleSuccessDTO(obj.seller,SUM(obj.visited),SUM(obj.deals)) FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupBySeller();

}

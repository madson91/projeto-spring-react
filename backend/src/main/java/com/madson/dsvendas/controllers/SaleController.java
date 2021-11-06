package com.madson.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madson.dsvendas.dto.SaleDTO;
import com.madson.dsvendas.entities.SaleSuccessDTO;
import com.madson.dsvendas.entities.SaleSumDTO;
import com.madson.dsvendas.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> getAll(Pageable pageable) {
		
		Page<SaleDTO> list = saleService.findAll(pageable);
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping(value = "/sum-by-seller" )
	public ResponseEntity<List<SaleSumDTO>> amountGroupBySeller() {
		
		List<SaleSumDTO> list = saleService.amountGroupBySeller();
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping(value = "/success-by-seller" )
	public ResponseEntity<List<SaleSuccessDTO>> successGroupBySeller() {
		
		List<SaleSuccessDTO> list = saleService.successGroupBySeller();
		return ResponseEntity.ok(list);
		
	}

}

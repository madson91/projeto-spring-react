package com.madson.dsvendas.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madson.dsvendas.dto.SaleDTO;
import com.madson.dsvendas.entities.Sale;
import com.madson.dsvendas.entities.SaleSuccessDTO;
import com.madson.dsvendas.entities.SaleSumDTO;
import com.madson.dsvendas.repositories.SaleRepository;
import com.madson.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> lista = repository.findAll(pageable);
		return lista.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupBySeller(){
		return repository.amountGroupBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupBySeller(){
		return repository.successGroupBySeller();
	}

}

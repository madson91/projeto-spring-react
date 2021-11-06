package com.madson.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madson.dsvendas.dto.SellerDTO;
import com.madson.dsvendas.entities.Seller;
import com.madson.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> lista = repository.findAll();
		return lista.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}

}

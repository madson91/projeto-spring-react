package com.madson.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madson.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}

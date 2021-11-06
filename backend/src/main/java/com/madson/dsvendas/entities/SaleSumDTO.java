package com.madson.dsvendas.entities;

import java.io.Serializable;

public class SaleSumDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String sellerName;
	private Double sum;

	public SaleSumDTO() {

	}

	public SaleSumDTO(Seller obj, Double sum) {
		this.sellerName = obj.getName();
		this.sum = sum;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

}

package com.lalit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Integer CountryId;
	private String Cname;
	
	
	public Country() {
		
	}


	public Country(Integer countryId, String cname) {
		super();
		CountryId = countryId;
		Cname = cname;
	}


	public Integer getCountryId() {
		return CountryId;
	}


	public void setCountryId(Integer countryId) {
		CountryId = countryId;
	}


	public String getCname() {
		return Cname;
	}


	public void setCname(String cname) {
		Cname = cname;
	}
	

}

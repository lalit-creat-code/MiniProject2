package com.lalit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class States {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer StateId;
	private String StateName;
	private Integer CountryId;
	
	public States() {
		
	}

	public States(Integer stateId, String stateName, Integer countryId) {
		super();
		StateId = stateId;
		StateName = stateName;
		CountryId = countryId;
	}

	public Integer getStateId() {
		return StateId;
	}

	public void setStateId(Integer stateId) {
		StateId = stateId;
	}

	public String getStateName() {
		return StateName;
	}

	public void setStateName(String stateName) {
		StateName = stateName;
	}

	public Integer getCountryId() {
		return CountryId;
	}

	public void setCountryId(Integer countryId) {
		CountryId = countryId;
	}
	
	
}
	
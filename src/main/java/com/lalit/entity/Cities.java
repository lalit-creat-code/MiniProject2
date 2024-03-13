package com.lalit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cities {
	private String CityName;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer CityId;
	private Integer StateId;
	public Cities() {
		
	}
	public Cities(String cityName, Integer cityId, Integer stateId) {
		super();
		CityName = cityName;
		CityId = cityId;
		StateId = stateId;
	}
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	public Integer getCityId() {
		return CityId;
	}
	public void setCityId(Integer cityId) {
		CityId = cityId;
	}
	public Integer getStateId() {
		return StateId;
	}
	public void setStateId(Integer stateId) {
		StateId = stateId;
	}
	
	

}

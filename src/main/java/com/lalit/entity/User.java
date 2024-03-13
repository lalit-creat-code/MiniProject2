package com.lalit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer UserId;
	private String Name;
	private String Email;
	private String Password;
	private Integer CountryId;
	private Integer StateId;
	private Integer CityId;
	private String PwdUpdated;
	@CreationTimestamp
	private   LocalDate CreatedDate;
	@CreationTimestamp
	private LocalDate UpdatedDate;
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Integer getCountryId() {
		return CountryId;
	}
	public void setCountryId(Integer countryId) {
		CountryId = countryId;
	}
	public Integer getStateId() {
		return StateId;
	}
	public void setStateId(Integer stateId) {
		StateId = stateId;
	}
	public Integer getCityId() {
		return CityId;
	}
	public void setCityId(Integer cityId) {
		CityId = cityId;
	}
	public String getPwdUpdated() {
		return PwdUpdated;
	}
	public void setPwdUpdated(String pwdUpdated) {
		PwdUpdated = pwdUpdated;
	}
	public LocalDate getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		CreatedDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return UpdatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		UpdatedDate = updatedDate;
	}
	
}
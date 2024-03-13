package com.lalit.binding;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
@Component
public class RegisterForm {
	private int UserId;
	private String Email;
	private String Password;
	private String Name;
	private Integer CountryId;
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
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
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
	private Integer StateId;
	private Integer CityId;
	private String PwdUpdated;
	
	
	

}

package com.lalit.services;

import java.util.Map;

import com.lalit.binding.LoginForm;
import com.lalit.binding.RegisterForm;
import com.lalit.binding.ResetPasswordForm;
import com.lalit.entity.User;

public interface ServiceInterface {

	public Map<Integer,String>getCountries();
	public Map<Integer,String>getStates(int CountryId);
	public Map<Integer,String>getCities(int StateId);
	public User getUser(String Email);
	public boolean saveUser(RegisterForm object);
	public User login(LoginForm object);
	public boolean resetpassword(ResetPasswordForm object);
	
	
}

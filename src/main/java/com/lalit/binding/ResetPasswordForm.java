package com.lalit.binding;

import org.springframework.stereotype.Component;

@Component
public class ResetPasswordForm {
	private int UserId;
	private String newPassword;
	private String confirmPassword;
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getconfirmPassword() {
		return confirmPassword;
	}
	public void setconfirmPassword(String oldPassword) {
		this.confirmPassword = oldPassword;
	}
	
	}
	



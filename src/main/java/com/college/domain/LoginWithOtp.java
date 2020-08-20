package com.college.domain;

public class LoginWithOtp {
	private String emailAddress;
	private String password;
	private String otp;
	




	


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getOtp() {
		return otp;
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}




	public LoginWithOtp(String emailAddress, String password, String otp) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
		this.otp = otp;
	}


	public LoginWithOtp() {
		super();
	}


	@Override
	public String toString() {
		return "LoginWithOtp [emailAddress=" + emailAddress + ", password=" + password + ", otp=" + otp + "]";
	}


	
	
	
}

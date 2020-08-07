package com.college.domain;

public class Login {
	private String emailAddress;
	private String password;
	
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

	public Login(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
	}
	public Login() {
		super();
	}
	@Override
	public String toString() {
		return "Login [emailAddress=" + emailAddress + ", password=" + password + "]";
	}
	
	
	
}

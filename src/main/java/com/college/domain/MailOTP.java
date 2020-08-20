package com.college.domain;

public class MailOTP {

	private String email;
	private String otpNumber;
	private Long expiryTime;

	public MailOTP() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtpNumber() {
		return otpNumber;
	}

	public void setOtpNumber(String otpNumber) {
		this.otpNumber = otpNumber;
	}

	public Long getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Long expiryTime) {
		this.expiryTime = expiryTime;
	}

	@Override
	public String toString() {
		return "MailOTP [email=" + email + ", otpNumber=" + otpNumber + ", expiryTime=" + expiryTime + "]";
	}

}

package com.college.service;

import com.college.domain.MailOTP;
import com.college.domain.ResponseObject;

public interface IOtpService {

	public String otpService();

	String generateOTP();

	ResponseObject sendOTPToMail(MailOTP mailOTP);

	ResponseObject verifyOTPOfMail(MailOTP mailOTP);

}

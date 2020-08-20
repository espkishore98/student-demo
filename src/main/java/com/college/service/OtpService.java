package com.college.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.college.utils.CommonUtils;

import com.college.domain.*;
import com.college.domain.ResponseObject;

@Service
public class OtpService implements IOtpService{
	@Autowired
	private JavaMailSender javaMailSender;
	private Map<String, MailOTP> mailOTPSData = new HashMap<String, MailOTP>();

	@Override
	public String otpService() {
	System.out.println("Generating OTP using random() : "); 
    System.out.print("You OTP is : "); 

    // Using numeric values 
    String numbers = "0123456789"; 

    // Using random method 
    Random rndm_method = new Random(); 

    char[] otp = new char[4];

    for (int i = 0; i < 4; i++) 
    { 
        // Use of charAt() method : to get character value 
        // Use of nextInt() as it is scanning the value as int 
        otp[i] = (char)(rndm_method.nextInt(10)+48);
        
    } 
    String otpresponse =new String( otp);
    return otpresponse; 

	}
	@Override
	public ResponseObject sendOTPToMail(MailOTP mailOTP) {

		if ((mailOTP.getEmail().isEmpty()) || (mailOTP.getEmail().length() == 0)) {
			return new ResponseObject(null, "provideEmailAddress", HttpStatus.BAD_REQUEST);
		}
	//	LOGGER.info("OTPSystemServiceImpl : sendOTPToMail " + mailOTP.toString());

		if (CommonUtils.isNull(mailOTP.getOtpNumber()) || (mailOTP.getOtpNumber().length() == 0)) {
			mailOTP.setOtpNumber(generateOTP());
		}
		mailOTP.setEmail(mailOTP.getEmail());
		mailOTP.setExpiryTime(System.currentTimeMillis() + 600000);

		mailOTPSData.put(mailOTP.getEmail(), mailOTP);

		try {
			SimpleMailMessage mail = new SimpleMailMessage();

			mail.setTo(mailOTP.getEmail());
			
			mail.setSubject("Your OTP for verification is ");
			mail.setText(" Your OTP is " + mailOTP.getOtpNumber());

			javaMailSender.send(mail);
		} catch (Exception e) {
			//LOGGER.error(e.getMessage(), e);
			return new ResponseObject(null, "invalidEmailAddress", HttpStatus.BAD_REQUEST);
		}
		return new ResponseObject("otp Sent successfully", null, HttpStatus.OK);

	}
	@Override
	public String generateOTP() {
		return String.valueOf(((int) (Math.random() * (1000000 - 100000))) + 100000);
	}
	@Override
	public ResponseObject verifyOTPOfMail(MailOTP mailOTP) {

		if (mailOTP == null) {
			return new ResponseObject(null, "Please provide details", HttpStatus.BAD_REQUEST);
		}

	//	LOGGER.info("OTPSystemServiceImpl : verifyOTPOfMobile " + mailOTP.toString());
		if (CommonUtils.isNull(mailOTP.getEmail()) && CommonUtils.isNull(mailOTP.getOtpNumber())
				|| (mailOTP.getEmail().length() == 0 && mailOTP.getOtpNumber().length() == 0)) {
			return new ResponseObject(null, "Please provide mail id and otp number", HttpStatus.BAD_REQUEST);
		}

		if (CommonUtils.isNull(mailOTP.getEmail()) || (mailOTP.getEmail().length() == 0)) {
			return new ResponseObject(null, "provideEmailAddress", HttpStatus.BAD_REQUEST);
		}

		if (CommonUtils.isNull(mailOTP.getOtpNumber()) || (mailOTP.getOtpNumber().length() == 0)) {
			return new ResponseObject(null, "provideOTP", HttpStatus.BAD_REQUEST);
		}

		if (mailOTPSData.containsKey(mailOTP.getEmail())) {
			MailOTP mailOTP2 = mailOTPSData.get(mailOTP.getEmail());
			if (mailOTP2 != null) {
				if (mailOTP2.getExpiryTime() >= System.currentTimeMillis()) {
					if (mailOTP2.getOtpNumber().equalsIgnoreCase(mailOTP.getOtpNumber())) {
						return new ResponseObject("oTPVerifiedSuccessful", null, HttpStatus.OK);
					}
					return new ResponseObject(null, "invalidOTP", HttpStatus.BAD_REQUEST);
				}
				return new ResponseObject(null, "expiredOTP", HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseObject(null, "invalidOTP", HttpStatus.BAD_REQUEST);

	}
	}

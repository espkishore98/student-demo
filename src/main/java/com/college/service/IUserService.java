package com.college.service;

import org.springframework.stereotype.Service;

import com.college.domain.Login;
import com.college.domain.RegisterUser;
import com.college.domain.ResponseObject;

@Service
public interface IUserService {
	
	public boolean emailChecker(String email);

	public ResponseObject registerUser(RegisterUser registerUser);

	ResponseObject userLogin(Login login);

	public ResponseObject studentConsole();
	
}

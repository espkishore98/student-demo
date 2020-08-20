package com.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.domain.Login;
import com.college.domain.LoginWithOtp;
import com.college.domain.RegisterUser;
import com.college.domain.ResponseObject;
import com.college.service.IUserService;


@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	
	@PostMapping("/registerUser")
	public ResponseObject registerUser(@RequestBody RegisterUser registerUser) {
		return userService.registerUser(registerUser);
	}
	@PostMapping("/login")
	public ResponseObject userLogin(@RequestBody Login login) {
		return userService.userLogin(login);
	}
	@PostMapping("/studentConsole")
	public ResponseObject studentConsole() {
		return userService.studentConsole();
	}
	@PostMapping("/login2")
	public ResponseObject login2(@RequestBody LoginWithOtp loginWithOtp) {
		return userService.Login2(loginWithOtp);
	}
	
	
	


}
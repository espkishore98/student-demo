package com.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
package com.students.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.students.demo.domain.StudentEntity;
import com.students.demo.service.IStudentService;




@RestController
//@RequestMapping("/app/esp")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	//@RequestMapping(path = "/student",method = RequestMethod.GET)
	@PostMapping("/student")
	public String studentDetails(@RequestBody StudentEntity studentEntity) {
		System.out.println("UserController : userRegister initiated successfully");
		return studentService.studentDetails(studentEntity);
		//return "hello";
	}
	

}

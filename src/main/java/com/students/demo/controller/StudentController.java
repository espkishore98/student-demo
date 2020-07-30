package com.students.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.students.demo.domain.GetStudentDetails;
import com.students.demo.domain.StudentEntity;
import com.students.demo.service.IStudentService;




@RestController
//@RequestMapping("/app/esp")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	//@RequestMapping(path = "/student",method = RequestMethod.GET)
	@PostMapping("/student")
	public String studentDetails(@RequestBody GetStudentDetails getStudentDetails ) {
		System.out.println("UserController : userRegister initiated successfully");
		return studentService.studentDetails(getStudentDetails);
		//return "hello";
	}
	@GetMapping("/getStudentById")
	public Optional<StudentEntity> studentDetailsById(@RequestParam Long id){
		return studentService.getStudentById(id);
	}
	@GetMapping("/getStudentByName")
	public List<StudentEntity> studentDetailsByName(@RequestParam String name){
		return studentService.getStudentByName(name);
	}
	@PostMapping("/updateStudentById")
	public String updateStudentDetails(@RequestParam Long id,@RequestParam Long dept){
		return studentService.updateStudentDetails(id, dept);
	}
	
	@PostMapping("/deleteStudentById")
	public String deleteStudentDetails(@RequestParam Long id){
		return studentService.deleteStudentDetails(id);
	}
	@PostMapping("/deleteStudentByName")
	public String deleteStudentDetails(@RequestParam String name){
		return studentService.deleteStudentDetailsByName(name);
	}
}

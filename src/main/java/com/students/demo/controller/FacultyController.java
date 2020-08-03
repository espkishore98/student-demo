package com.students.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.students.demo.domain.FacultyEntity;
import com.students.demo.domain.GetFacultydDetails;
import com.students.demo.service.IFacultyService;

@RestController
public class FacultyController {
	@Autowired
	IFacultyService facultyService;
	
//	@PostMapping("/insertFaculty")
//	public String insertfaculty(@RequestBody GetFacultydDetails facultyDetails) {
//		return facultyService.facultyDetails(facultyDetails);
//	}
//	@GetMapping("/getFacultyByName")
//	public List<FacultyEntity> getFacultyDetailsByName(@RequestParam String facultyName) {
//		return facultyService.getFacultyByName(facultyName);
//	}
//	
//	@PostMapping("/updateFacultySalary")
//	public String updateFacultySalary(@RequestParam Long facultyId, @RequestParam int salary ) {
//		return facultyService.updateFacultySalary(facultyId, salary);
//	}
//	
//	@PostMapping("/deleteFaculty")
//	public String deleteFaculty(@RequestParam Long facultyId ) {
//		return facultyService.deleteFacultyById(facultyId);
//	}
//	@PostMapping("/deleteFacultyByName")
//	public String deleteFacultyByName(@RequestParam String facultyName ) {
//		return facultyService.deleteFacultyDetailsByName(facultyName);
//	}

}

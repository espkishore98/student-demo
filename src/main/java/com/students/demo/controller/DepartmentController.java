package com.students.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.students.demo.domain.DepartmentEntity;
import com.students.demo.service.IDepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	IDepartmentService depService;
//	
//	
//	
//	@PostMapping("/Department")
//	public String InsertDepartment(@RequestBody DepartmentEntity depEntity ) {
//		return depService.InsertDepartment(depEntity);
//		
//	}
//	
//	
//	
//	@PostMapping("/getDepById")
//	public Optional<DepartmentEntity> getDepartmentDetails(@RequestParam Long id) {
//		return depService.GetDepartmentById(id);
//	}
//	

}

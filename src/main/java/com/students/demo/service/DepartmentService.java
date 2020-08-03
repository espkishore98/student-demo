package com.students.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.demo.domain.DepartmentEntity;
import com.students.demo.repository.DepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService{
	@Autowired
	DepartmentRepository departmentRepo;
	
	
	
	
//	@Override
//	public String InsertDepartment(DepartmentEntity depEntity) {
//		if(depEntity.getDepName()==null) {
//		return "Please insert department name";
//		}
//		departmentRepo.saveAndFlush(depEntity);
//
//		return "Department inserted successfully";
//		
//		
//		
//	}
//	
//	@Override
//	public Optional<DepartmentEntity> GetDepartmentById(Long depId) {
//		return departmentRepo.findById(depId);
//		
//		
//	}
//	

}

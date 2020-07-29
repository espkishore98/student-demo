package com.students.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.demo.domain.StudentEntity;
import com.students.demo.repository.StudentRepository;



@Service
public class StudentService implements IStudentService {
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public String studentDetails(StudentEntity studentEntity) {
		if(studentEntity.getStudentName()==null) {
			
			return "student name required";
		}
		
		studentRepo.saveAndFlush(studentEntity);
		return "success";
		
	}
	
	

}

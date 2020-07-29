package com.students.demo.service;


import org.springframework.stereotype.Service;


import com.students.demo.domain.StudentEntity;

@Service
public interface IStudentService {
	
	public String studentDetails(StudentEntity studentEntity);

}

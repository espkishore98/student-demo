package com.students.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.students.demo.domain.GetStudentDetails;
import com.students.demo.domain.RegisterUser;
import com.students.demo.domain.StudentEntity;

@Service
public interface IStudentService {

	String registerUser(RegisterUser registerUser);
	
//	public String studentDetails(GetStudentDetails getStudentDetails);
//
//	Optional<StudentEntity> getStudentById(Long id);
//
//	List<StudentEntity> getStudentByName(String name);
//
//	String updateStudentDetails(Long id, Long dept);
//
//	String deleteStudentDetails(Long id);
//
//	public String deleteStudentDetailsByName(String name);
//


}

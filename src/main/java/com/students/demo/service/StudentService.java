package com.students.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.demo.domain.DepartmentEntity;
import com.students.demo.domain.FacultyEntity;
import com.students.demo.domain.GetStudentDetails;
import com.students.demo.domain.RegisterUser;
import com.students.demo.domain.StudentEntity;
import com.students.demo.domain.UsersEntity;
import com.students.demo.repository.DepartmentRepository;
import com.students.demo.repository.FacultyRepository;
import com.students.demo.repository.StudentRepository;
import com.students.demo.repository.UsersRepository;



@Service
public class StudentService implements IStudentService {
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private FacultyRepository facultyRepo;
	@Autowired
	private UsersRepository userRepo;
//	
//	@Override
//	public String studentDetails(GetStudentDetails getStudentDetails) {
//		
//		if(getStudentDetails.getStudentName()==null) {
//			
//			return "student name required";
//		}
//		if(getStudentDetails.getDeptNumber()==null) {
//			return "please enter department number";
//		}
//		DepartmentEntity entity=null;
//		Optional<DepartmentEntity> opt=departmentRepo.findById(getStudentDetails.getDeptNumber());
//		if(opt.isPresent()) {
//		entity=opt.get();
//		}
//		StudentEntity sEntity = new StudentEntity(getStudentDetails.getStudentName(),getStudentDetails.getAddress(),getStudentDetails.getPhoneNumber(),entity);
//		studentRepo.saveAndFlush(sEntity);
//		return "success";
//		
//	}
//	
//	@Override
//	public Optional<StudentEntity> getStudentById(Long id) {
//		return studentRepo.findById(id);
//	 
//	}
//	
//	@Override
//	public List<StudentEntity> getStudentByName(String name) {
//		return studentRepo.findStudentByName(name);
//	 
//	}
//	
//	@Override
//	public String  updateStudentDetails(Long id, Long dept) {
//		DepartmentEntity entity=null;
//		Optional<DepartmentEntity> opt=departmentRepo.findById(dept);
//		if(opt.isPresent()) {
//		entity=opt.get();
//		}
//		studentRepo.updateStudentDetails(id, entity);
//		return "student record updated";
//
//	}
//	@Override
//	public String deleteStudentDetails(Long id) {
//		studentRepo.deleteById(id);
//		return "Record successfully deleted";
//	}
//
//	@Override
//	public String deleteStudentDetailsByName(String name) {
//		studentRepo.deleteStudentByName(name);
//		return name+"\'s" +" details deleted successfly";
//		
//	}
	
	public String registerUser(RegisterUser registerUser) {
		
		
		DepartmentEntity entity =departmentRepo.findByName(registerUser.getDepartmentName());
		StudentEntity studentObject = null;
		FacultyEntity	facultyObject = null;
		if(registerUser.getType().equalsIgnoreCase("student")) {
			studentObject = new StudentEntity(registerUser.getUserId(),registerUser.getFirstName(),registerUser.getEmail(),entity);
		studentRepo.saveAndFlush(studentObject);

		}
		else {
		facultyObject = new FacultyEntity(registerUser.getUserId(),registerUser.getFirstName(),registerUser.getEmail(),entity);
			facultyRepo.saveAndFlush(facultyObject);
		}
			
		UsersEntity userEntityObject = new UsersEntity(registerUser.getUserId(),registerUser.getFirstName(),registerUser.getLastName(),registerUser.getEmail(),registerUser.getPassword(),registerUser.getType(),studentObject,facultyObject,entity);
		userRepo.saveAndFlush(userEntityObject);
		return "successFully registerd";
		
	}
	


}

package com.college.service;

import java.util.Calendar;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.college.constants.ErrorMessages;
import com.college.constants.MessageConstants;
import com.college.constants.SuccessMessages;
import com.college.domain.Department;
import com.college.domain.Faculty;
import com.college.domain.RegisterUser;
import com.college.domain.ResponseObject;
import com.college.domain.Student;
import com.college.domain.Users;
import com.college.repository.DepartmentRepository;
import com.college.repository.FacultyRepository;
import com.college.repository.StudentRepository;
import com.college.repository.UsersRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private UsersRepository userRepository;
	
	@Override
	public boolean emailChecker(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null) {
			return false;
		}
		return pat.matcher(email).matches();
	}

	@Override
	public ResponseObject registerUser(RegisterUser registerUser) {
		
		try {
			Student student=null;
			Faculty faculty=null;
			
			Department department=departmentRepository.findByName(registerUser.getDepartmentName());
			/*
			 * validations for dept entity
			*/
			if(registerUser.getType().equalsIgnoreCase(MessageConstants.STUDENT)) {
				student=new Student(registerUser.getUserId(),registerUser.getFirstName().concat(" ").concat(registerUser.getLastName()), 
						registerUser.getAddress(), registerUser.getEmailId(), Calendar.getInstance(), Calendar.getInstance(),department);
				studentRepository.saveAndFlush(student);
			}else {
				faculty=new Faculty(registerUser.getUserId(), registerUser.getFirstName().concat(" ").concat(registerUser.getLastName()),
						registerUser.getAddress(), registerUser.getEmailId(), Calendar.getInstance(), Calendar.getInstance(),department);
				facultyRepository.saveAndFlush(faculty);
			}
			//saving user details
			Users user=new Users(registerUser.getUserId(), registerUser.getFirstName(), registerUser.getLastName(),
					registerUser.getEmailId(), registerUser.getPassword(), registerUser.getType(), 
					Calendar.getInstance(), Calendar.getInstance(), student, faculty, department);
			user=userRepository.saveAndFlush(user);
			if(user==null) {
				return new ResponseObject(null, ErrorMessages.REGISTRATION_FAILED, HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseObject(null, SuccessMessages.REGISTERED_SUCCESSFULLY, HttpStatus.BAD_REQUEST);
			}
			
		}catch(Exception e) {
			return new ResponseObject(null, e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}

}

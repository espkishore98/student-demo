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
import com.college.utils.CommonUtils;

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
		
		if ((CommonUtils.isNull(registerUser.getUserId()) || (registerUser.getUserId().length() == 0))) {
			return new ResponseObject(null, ErrorMessages.PROVIDE_USER_ID, HttpStatus.BAD_REQUEST);
		}
		if ((CommonUtils.isNull(registerUser.getFirstName()) || (registerUser.getFirstName().length() == 0))) {
			return new ResponseObject(null, ErrorMessages.PROVIDE_FIRST_NAME, HttpStatus.BAD_REQUEST);
		}
		if ((CommonUtils.isNull(registerUser.getLastName()) || (registerUser.getLastName().length() == 0))) {
			return new ResponseObject(null, ErrorMessages.PROVIDE_LAST_NAME, HttpStatus.BAD_REQUEST);
		}
		if ((CommonUtils.isNull(registerUser.getEmailId()) || (registerUser.getEmailId().length() == 0))) {
			return new ResponseObject(null, ErrorMessages.PROVIDE_EMAIL_ID, HttpStatus.BAD_REQUEST);
		}
		if ((CommonUtils.isNull(registerUser.getPassword()) || (registerUser.getPassword().length() == 0))) {
			return new ResponseObject(null, ErrorMessages.PROVIDE_PASSWORD, HttpStatus.BAD_REQUEST);
		}
		boolean checker = emailChecker(registerUser.getEmailId());
		if (checker == false) {
		return new ResponseObject(null, ErrorMessages.CHECK_EMAIL_FORMAT, HttpStatus.BAD_REQUEST);
		}
		if ((CommonUtils.isNull(registerUser.getDepartmentName()) || (registerUser.getDepartmentName().length() == 0))) {
			return new ResponseObject(null, ErrorMessages.PROVIDE_DEPARTMENT_NAME, HttpStatus.BAD_REQUEST);
		}
		if ((CommonUtils.isNull(registerUser.getType()) || (registerUser.getType().length() == 0))) {
			return new ResponseObject(null, ErrorMessages.PROVIDE_USER_TYPE, HttpStatus.BAD_REQUEST);
		}
		
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
				return new ResponseObject(null, SuccessMessages.REGISTERED_SUCCESSFULLY, HttpStatus.OK);
			}
			
		}catch(Exception e) {
			return new ResponseObject(null, e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}

}

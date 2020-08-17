package com.college.service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.college.security.Iconstants;
import com.college.constants.ErrorMessages;
import com.college.constants.MessageConstants;
import com.college.constants.SuccessMessages;
import com.college.domain.Department;
import com.college.domain.Faculty;
import com.college.domain.Login;
import com.college.domain.RegisterUser;
import com.college.domain.ResponseObject;
import com.college.domain.Student;
import com.college.domain.Users;
import com.college.repository.DepartmentRepository;
import com.college.repository.FacultyRepository;
import com.college.repository.StudentRepository;
import com.college.repository.UsersRepository;
import com.college.utils.CommonUtils;
//import com.college.security.JwtTokenProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.college.service.UserService;
import com.college.domain.AuthUser;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserService implements IUserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private UsersRepository userRepository;
	
	private AuthenticationManager authenticationManager;
	private PasswordEncoder passwordEncoder;
	//private JwtTokenProvider tokenProvider;
	
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
		
		
		
		
		
		String userType=registerUser.getType().trim().toLowerCase();
		//LOGGER.info("companyName:"+userType);

		if(!userType.matches("^[a-zA-Z]*$")) {
			return new ResponseObject(null,ErrorMessages.SPACES_AND_CHARACTER_NOTALLOWED,HttpStatus.BAD_REQUEST);
		}
		
		try {
			Student student=null;
			Faculty faculty=null;
			List<Users> userCheck=userRepository.findAll();
			
			//LOGGER.info("time taken till get Users:" + (System.currentTimeMillis() - startTime));
			for (Users user : userCheck) {
				
				if (user.getEmailId().toLowerCase().equals(registerUser.getEmailId().toLowerCase())) {
					return new ResponseObject(null, ErrorMessages.EMAIL_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
				}
				
			}

			
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
			Users user1=new Users(registerUser.getUserId(), registerUser.getFirstName(), registerUser.getLastName(),
					registerUser.getEmailId(), registerUser.getPassword(), registerUser.getType(), 
					Calendar.getInstance(), Calendar.getInstance(), student, faculty, department);
			user1=userRepository.saveAndFlush(user1);
			if(user1==null) {
				return new ResponseObject(null, ErrorMessages.REGISTRATION_FAILED, HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseObject(null, SuccessMessages.REGISTERED_SUCCESSFULLY, HttpStatus.OK);
			}
		
		
		}catch(Exception e) {
			return new ResponseObject(null, e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
@Override
public ResponseObject userLogin(Login login) {
	String jwttoken = "";
	if(CommonUtils.isNull(login.getEmailAddress())){
		return new ResponseObject(null,ErrorMessages.ENTER_EMAIL_ADDRESS,HttpStatus.BAD_REQUEST);
	}
	Users userCheck=userRepository.getEmail(login.getEmailAddress());


	if(CommonUtils.isNull(userCheck.getEmailId())) {
		return new ResponseObject(null,ErrorMessages.ENTER_REGISTER_EMAIL,HttpStatus.BAD_REQUEST);
	}
	if(!login.getPassword().equalsIgnoreCase(userCheck.getPassword())) {
		return new ResponseObject(null,ErrorMessages.Enter_CORRECT_PASSWORD,HttpStatus.BAD_REQUEST); 
	}
	if(!login.getEmailAddress().equalsIgnoreCase(userCheck.getEmailId())) {
		return new ResponseObject(null,ErrorMessages.ENTER_REGISTER_EMAIL,HttpStatus.BAD_REQUEST);
	}
	try {
		 Map<String, Object> claims = new HashMap<String, Object>();
         claims.put("usr", login.getEmailAddress());
         claims.put("sub", "Authentication token");
         claims.put("iss", Iconstants.ISSUER);
         claims.put("rol", "Student, Faculty");
         claims.put("iat", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

         jwttoken = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, Iconstants.SECRET_KEY).compact();
         System.out.println("Returning the following token to the user= "+ jwttoken);
         return new ResponseObject(jwttoken,null, HttpStatus.OK);
	}catch (Exception e) {
		return new ResponseObject(e.getMessage(),null,HttpStatus.BAD_REQUEST);
		}
	

	
	
}

public static String resolveToken(HttpServletRequest req) {
	String bearerToken = req.getHeader("Authorization");
	if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
		return bearerToken.substring(7, bearerToken.length());
	}
	return null;
}

@Override
public ResponseObject studentConsole() {
	// TODO Auto-generated method stub
	return new ResponseObject("this is studentConsole page",null,HttpStatus.OK);
}

	

}

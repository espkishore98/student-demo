package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.college.domain.Login;
import com.college.domain.Users;


public interface UsersRepository extends JpaRepository<Users, Long> {

	@Query(value="select c from Users c where c.emailId=:emailAddress ",nativeQuery=false)
	Users getEmail(String emailAddress);
	
	@Query(value = "select u from Users u ", nativeQuery = false)
	public List<Users> findAll();

	
	

}
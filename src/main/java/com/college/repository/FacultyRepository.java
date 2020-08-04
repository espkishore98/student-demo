package com.college.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.college.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

	@Query(value="select f from Faculty f where f.facultyName=:facultyName",nativeQuery = false)
	public List<Faculty> findFacultyByName(String facultyName);
	
	@Modifying
	@Transactional
	@Query(value="delete from Faculty f where f.facultyName=:facultyName",nativeQuery = false)
	public void deleteFacultyByName(String facultyName);
	
}

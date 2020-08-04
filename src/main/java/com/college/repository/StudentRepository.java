package com.college.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.college.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query(value="select s from Student s where s.studentName=:studentName",nativeQuery = false)
	public List<Student> findStudentByName(String studentName);
	  
	@Modifying
	@Transactional
	@Query(value="delete from Student s where s.studentName=:studentName",nativeQuery = false)
	public void deleteStudentByName(String studentName);
	

}

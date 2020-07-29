package com.students.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.demo.domain.StudentEntity;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
	
	

}

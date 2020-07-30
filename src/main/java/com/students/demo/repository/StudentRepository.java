package com.students.demo.repository;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.students.demo.domain.DepartmentEntity;
import com.students.demo.domain.GetStudentDetails;
import com.students.demo.domain.StudentEntity;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
	
	
	@Query(value="select s from StudentEntity s where s.studentName=:studentName",nativeQuery = false)
	public List<StudentEntity> findStudentByName(String studentName);
	
	@Modifying
	@Transactional
	@Query(value="update StudentEntity s set s.department=:department where s.id=:id",nativeQuery=false)
	public void updateStudentDetails(Long id,DepartmentEntity department);
	  
	@Modifying
	@Transactional
	@Query(value="delete from StudentEntity s where s.studentName=:studentName",nativeQuery = false)
	public void deleteStudentByName(String studentName);
	

}

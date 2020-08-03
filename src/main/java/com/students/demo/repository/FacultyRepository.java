package com.students.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.students.demo.domain.FacultyEntity;


public interface FacultyRepository extends JpaRepository<FacultyEntity, Long> {

	@Query(value="select f from FacultyEntity f where f.facultyName=:facultyName",nativeQuery = false)
	public List<FacultyEntity> findFacultyByName(String facultyName);

//	@Modifying
//	@Transactional
//	@Query(value="update FacultyEntity f set f.salary=:salary where f.facultyId=:facultyId",nativeQuery=false)
//	public void updateFacultySalary(Long facultyId, int salary);
	
	@Modifying
	@Transactional
	@Query(value="delete FacultyEntity f where f.facultyName=:facultyName",nativeQuery = false)
	public void deleteFacultyByName(String facultyName);
	
}

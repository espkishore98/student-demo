package com.students.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.students.demo.domain.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
	
	@Query(value="select d from  DepartmentEntity d where d.depname=:departmentName",nativeQuery=false)
	public DepartmentEntity findByName(String departmentName);

}

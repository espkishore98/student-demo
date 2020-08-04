package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.college.domain.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	@Query(value="select d from  Department d where d.deptName=:departmentName",nativeQuery=false)
	public Department findByName(String departmentName);

}
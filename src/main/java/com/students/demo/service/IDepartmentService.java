package com.students.demo.service;

import java.util.Optional;

import com.students.demo.domain.DepartmentEntity;

public interface IDepartmentService {

	Optional<DepartmentEntity> GetDepartmentById(Long depId);

	String InsertDepartment(DepartmentEntity depEntity);

}

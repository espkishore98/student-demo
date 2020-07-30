package com.students.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.demo.domain.DepartmentEntity;
import com.students.demo.domain.FacultyEntity;
import com.students.demo.domain.GetFacultydDetails;
import com.students.demo.repository.DepartmentRepository;
import com.students.demo.repository.FacultyRepository;

import java.util.List;
import 	java.util.Optional;

@Service
public class FacultyService implements IFacultyService{
	@Autowired
	FacultyRepository facultyRepo;
	@Autowired
	DepartmentRepository departmentRepo;
	
	@Override
	public String facultyDetails(GetFacultydDetails getFacultyDetails) {
		if(getFacultyDetails.getSalary()<0) {
			return "please enter salary";
			}	
		DepartmentEntity entity=null;
		Optional<DepartmentEntity> opt = departmentRepo.findById(getFacultyDetails.getDepartmentId());
		
		if(opt.isPresent()) {
		entity=opt.get();
		}
	
		FacultyEntity fEntity= new FacultyEntity(getFacultyDetails.getFacultyName(), getFacultyDetails.getSalary(), getFacultyDetails.getAddress(), entity);
		
		facultyRepo.saveAndFlush(fEntity);
		return "faculty details inserted successfully";
		
	}
	
	@Override
	public List<FacultyEntity>  getFacultyByName(String facultyName) {
		return facultyRepo.findFacultyByName(facultyName);
		
	}
	
	@Override
	public String updateFacultySalary(Long facultyId,int salary) {
		facultyRepo.updateFacultySalary(facultyId,salary);
		return "salary updated";
	}
	
	@Override
	public String deleteFacultyById(Long facultyId) {
		facultyRepo.deleteById(facultyId);
		return "faculty details deleted successfully";
	}
	
	@Override
	public String deleteFacultyDetailsByName(String facultyName) {
		facultyRepo.deleteFacultyByName(facultyName);
		return facultyName+"\'s" +" details deleted successfly";
		
	}
	
	
	

}

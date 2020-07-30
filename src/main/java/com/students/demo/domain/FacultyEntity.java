package com.students.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="faculty")
public class FacultyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="faculty_id")
	private Long facultyId;
	@Column(name="faculty_name")
	private String facultyName;
	@Column(name="salary")
	private int salary;
	@Column(name="address")
	private String address;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name="department_id")
	private DepartmentEntity department;
	public Long getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public DepartmentEntity getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
	public FacultyEntity(String facultyName, int salary, String address, DepartmentEntity department) {
		super();
		this.facultyName = facultyName;
		this.salary = salary;
		this.address = address;
		this.department = department;
	}
	public FacultyEntity() {
		super();
	}
	@Override
	public String toString() {
		return "FacultyEntity [facultyId=" + facultyId + ", facultyName=" + facultyName + ", salary=" + salary
				+ ", address=" + address + ", department=" + department + "]";
	}

}

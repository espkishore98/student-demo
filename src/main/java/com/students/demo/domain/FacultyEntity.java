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
	@Column(name="id")
	private Long id;
	@Column(name="faculty_id")
	private String facultyId;
	@Column(name="faculty_name")
	private String facultyName;
	@Column(name="email")
	private String facultyMailId;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name="department_id")
	private DepartmentEntity department;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getFacultyMailId() {
		return facultyMailId;
	}
	public void setFacultyMailId(String facultyMailId) {
		this.facultyMailId = facultyMailId;
	}
	public DepartmentEntity getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
	public FacultyEntity(String facultyId, String facultyName, String facultyMailId, DepartmentEntity department) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.facultyMailId = facultyMailId;
		this.department = department;
	}
	public FacultyEntity() {
		super();
	}
	@Override
	public String toString() {
		return "FacultyEntity [id=" + id + ", facultyId=" + facultyId + ", facultyName=" + facultyName
				+ ", facultyMailId=" + facultyMailId + ", department=" + department + "]";
	}
	

}

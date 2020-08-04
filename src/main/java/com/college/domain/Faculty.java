package com.college.domain;

import java.util.Calendar;

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
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(name="faculty_id")
	private String facultyId;
	@Column(name="name")
	private String facultyName;
	@Column(name="address")
	private String address;
	@Column(name="email_address")
	private String emailId;
	@Column(name="created_on")
	private Calendar createdOn;
	@Column(name="modified_on")
	private Calendar modifiedOn;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name="department_id")
	private Department department;
	
	public Long getId() {
		return id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Calendar getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}
	public Calendar getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Calendar modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Faculty(String facultyId, String facultyName, String address, String emailId, Calendar createdOn,
			Calendar modifiedOn, Department department) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.address = address;
		this.emailId = emailId;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		this.department = department;
	}
	
	public Faculty() {
		super();
	}
	
	@Override
	public String toString() {
		return "Faculty [id=" + id + ", facultyId=" + facultyId + ", facultyName=" + facultyName + ", address="
				+ address + ", emailId=" + emailId + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn
				+ ", department=" + department + "]";
	}

}
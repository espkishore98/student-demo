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
@Table(name = "student")
public class Student {

	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "roll_number")
	private String studentId;
	@Column(name = "name")
	private String studentName;
	@Column(name="address")
	private String address;
	@Column(name = "email_address")
	private String emailId;
	@Column(name="created_on")
	private Calendar createdOn;
	@Column(name="modified_on")
	private Calendar modifiedOn;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "department_id") // join column to join from different table
	private Department department;

	public Long getId() {
		return id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

	public Student(String studentId, String studentName, String address, String emailId, Calendar createdOn,
			Calendar modifiedOn, Department department) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = address;
		this.emailId = emailId;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		this.department = department;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentId=" + studentId + ", studentName=" + studentName + ", address="
				+ address + ", emailId=" + emailId + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn
				+ ", department=" + department + "]";
	}
	
}
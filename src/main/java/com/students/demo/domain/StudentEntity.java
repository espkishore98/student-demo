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
@Table(name = "students")
public class StudentEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String studentName;

	@Column(name = "address") 
	private String address;
	 
 @Column(name = "phone_number") 
 private Long phoneNumber;
 
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
 @JoinColumn(name = "department") //join column to join from different table
 private DepartmentEntity department;
	



	public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
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

public Long getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(Long phoneNumber) {
	this.phoneNumber = phoneNumber;
}





	public DepartmentEntity getDepartment() {
	return department;
}

public void setDepartment(DepartmentEntity department) {
	this.department = department;
}

	public StudentEntity() {
		super();
	}


	public StudentEntity(String studentName, String address, Long phoneNumber, DepartmentEntity department) {
		super();
		this.studentName = studentName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.department = department;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", studentName=" + studentName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", department=" + department + "]";
	}

}

package com.students.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class StudentEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rollNumber;
	@Column(name = "name")
	private String studentName;

	@Column(name = "address") 
	private String address;
	 
 @Column(name = "phone_number") 
 private Long phoneNumber;

	



	public Long getRollNumber() {
	return rollNumber;
}
public void setRollNumber(Long rollNumber) {
	this.rollNumber = rollNumber;
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
	public StudentEntity() {
		super();
	}

	public StudentEntity( String studentName, String address, Long phoneNumber) {
		super();
		
		this.studentName = studentName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "StudentEntity [rollNumber=" + rollNumber + ", studentName=" + studentName + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}

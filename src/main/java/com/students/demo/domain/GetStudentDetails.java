package com.students.demo.domain;




public class GetStudentDetails {
	private String studentName;
	private String address;
	private Long phoneNumber;
	private Long deptNumber;

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
	public Long getDeptNumber() {
	return deptNumber;
	}
	public void setDeptNumber(Long deptNumber) {
	this.deptNumber = deptNumber;
	}
	public GetStudentDetails(String studentName, String address, Long phoneNumber, Long deptNumber) {
		super();
		this.studentName = studentName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.deptNumber = deptNumber;
	}
	
	public GetStudentDetails() {
		super();
	}
	
	@Override
	public String toString() {
		return "GetStudentDetails [studentName=" + studentName + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", deptNumber=" + deptNumber + "]";
	}


	


	}


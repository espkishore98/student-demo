package com.college.domain;

public class RegisterUser {

	private String userId;
	private String firstName;
	private String lastName;
	private String address;
	private String emailId;
	private String password;
	private String type;
	private String departmentName;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public RegisterUser(String userId, String firstName, String lastName, String address, String emailId,
			String password, String type, String departmentName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailId = emailId;
		this.password = password;
		this.type = type;
		this.departmentName = departmentName;
	}
	
	public RegisterUser() {
		super();
	}
	
	@Override
	public String toString() {
		return "RegisterUser [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", emailId=" + emailId + ", password=" + password + ", type=" + type + ", departmentName="
				+ departmentName + "]";
	}

}
package com.students.demo.domain;

public class GetFacultydDetails {
	private String facultyName;
	private int salary;
	private String address;
	private Long departmentId;
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
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public GetFacultydDetails(String facultyName, int salary, String address, Long departmentId) {
		super();
		this.facultyName = facultyName;
		this.salary = salary;
		this.address = address;
		this.departmentId = departmentId;
	}
	public GetFacultydDetails() {
		super();
	}
	@Override
	public String toString() {
		return "GetFacultydDetails [facultyName=" + facultyName + ", salary=" + salary + ", address=" + address
				+ ", departmentId=" + departmentId + "]";
	}

}

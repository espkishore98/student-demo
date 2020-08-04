package com.college.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="department_id")
	private String deptId;
	@Column(name="department_name")
	private String deptName;
	@Column(name="created_on")
	private Calendar createdOn;
	@Column(name="modified_on")
	private Calendar modifiedOn;
	
	public Long getId() {
		return id;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
	
	public Department(String deptId, String deptName, Calendar createdOn, Calendar modifiedOn) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}
	
	public Department() {
		super();
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", deptId=" + deptId + ", deptName=" + deptName + ", createdOn=" + createdOn
				+ ", modifiedOn=" + modifiedOn + "]";
	}
	
}
package com.students.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class DepartmentEntity {
	@Id
	@Column(name="department_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long depId;
	@Column(name="department")
	private String depName;
	public Long getDepId() {
		return depId;
	}
	public void setDepId(Long depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	
	
	
	public DepartmentEntity( String depName) {
		super();
	
		this.depName = depName;
	}
	
	
	public DepartmentEntity() {
		super();
	}
	
	@Override
	public String toString() {
		return "DepartmentEntity [depId=" + depId + ", depName=" + depName + "]";
	}
	
	

}

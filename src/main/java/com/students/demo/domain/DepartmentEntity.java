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
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="department_id")
	private String depid;
	@Column(name="department_name")
	private String depname;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepid() {
		return depid;
	}
	public void setDepid(String depid) {
		this.depid = depid;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public DepartmentEntity(String depid, String depname) {
		super();
		this.depid = depid;
		this.depname = depname;
	}
	public DepartmentEntity() {
		super();
	}
	@Override
	public String toString() {
		return "DepartmentEntity [id=" + id + ", depid=" + depid + ", depname=" + depname + "]";
	}

	
	
	

	

	
	

}

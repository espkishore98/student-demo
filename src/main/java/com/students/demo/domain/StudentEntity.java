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
@Table(name = "student")
public class StudentEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "student_id")
	private String studentId;
	@Column(name = "student_name")
	private String studentName;

	@Column(name = "email")
	private String studentMailId;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "department_id") // join column to join from different table
	private DepartmentEntity department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStudentMailId() {
		return studentMailId;
	}

	public void setStudentMailId(String studentMailId) {
		this.studentMailId = studentMailId;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public StudentEntity(String studentId, String studentName, String studentMailId, DepartmentEntity department) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMailId = studentMailId;
		this.department = department;
	}

	public StudentEntity() {
		super();
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", studentId=" + studentId + ", studentName=" + studentName
				+ ", studentMailId=" + studentMailId + ", department=" + department + "]";
	}

	
}

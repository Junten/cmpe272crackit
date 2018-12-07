package io.sjsu.cmpe272.model;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
	
	@Id
	@Column(name = "dept_no", nullable = false)
	private String deptNo;
	
	@Column(name = "dept_name", length = 40, nullable = false)
	private String deptName;
	
	public void setDeptNumber(String deptNumber) {
		this.deptNo = deptNumber;
	}
	
	public String getDeptNumber() {
		return deptNo;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public String getDeptName() {
		return deptName;
	}
}

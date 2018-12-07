package io.sjsu.cmpe272.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "emp_no", nullable = false)
	private int empNo;
	
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "hire_date", nullable = false)
	private Date hireDate;
	
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	
	public int getEmpNo() {
		return empNo;
	}
	
	public void setbirthDate (Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.firstName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setHireDate(Date hireDate ) {
		this.hireDate = hireDate;
	}
	
	public Date getHireDate() {
		return hireDate;
	}
}

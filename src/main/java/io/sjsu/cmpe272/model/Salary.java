package io.sjsu.cmpe272.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@IdClass(SalaryId.class)
@Table(name = "salaries")
public class Salary {
	
	@Id
    @JoinColumn(name = "emp_no", nullable = false)
	private int empNo;
	
	@Column(name = "salary", nullable = false)
	private int salary;
	
    @Id
	@Column(name = "from_date", length = 50, nullable = false)
	private Date fromDate;
	
    @Column(name = "to_date", length = 50, nullable = false)
	private Date toDate;
    
    public void setEmpNo(int empNo) {
    	this.empNo = empNo;
    }
    
    public int getEmpNo() {
    	return empNo;
    }
    
    public void setSalary(int salary) {
    	this.salary = salary;
    }
    
    public int getSalary() {
    	return salary;
    }
    
    public void setFromDate(Date fromDate) {
    	this.fromDate = fromDate;
    }
    
    public Date getFromDate() {
    	return fromDate;
    }
    
    public void setToDate(Date toDate) {
    	this.toDate = toDate;
    }
    
    public Date getToDate() {
    	return toDate;
    }
}

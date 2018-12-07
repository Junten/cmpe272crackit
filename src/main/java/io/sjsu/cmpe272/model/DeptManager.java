package io.sjsu.cmpe272.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@IdClass(DeptManagerId.class)
@Table(name = "dept_manager")
public class DeptManager {

	@Id
    @Column(name = "emp_no", nullable = false)
	private int empNo;
	
	@Id
	@Column(name = "dept_no", nullable = false)
	private String deptNo;
	
	@Column(name = "from_date", length = 50, nullable = false)
	private Date fromDate;
	
    @Column(name = "to_date", length = 50, nullable = false)
	private Date toDate;
	
    public void setDeptNo(String deptNo) {
    	this.deptNo = deptNo; 
    }
    
    public String getDeptNo() {
    	return deptNo;
    }
    
    public void setEmpNo(int empNo) {
    	this.empNo = empNo;
    }
    
    public int getEmpNo() {
    	return empNo;
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


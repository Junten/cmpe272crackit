package io.sjsu.cmpe272.model;

import java.util.Date;

import javax.persistence.*;


@Entity
@IdClass(TitleId.class)
@Table(name = "titles")
public class Title {
	
    @Id
    @JoinColumn(name = "emp_no", nullable = false)
	private int empNo;
	
    @Id
    @Column(name = "title", length = 50, nullable = false)
	private String title;
	
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
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public String getTitle() {
    	return title;
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

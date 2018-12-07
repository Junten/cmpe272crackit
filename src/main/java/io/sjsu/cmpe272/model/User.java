package io.sjsu.cmpe272.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	@Column(name = "username", length = 36, nullable = false)
    private String username;
	
	@Column(name = "password", length = 128)
    private String password;

    @Transient
    private String passwordConfirm;
    
    @OneToOne
    @JoinColumn(name = "emp_no")
    private Employee employee;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
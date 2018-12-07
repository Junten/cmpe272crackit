package io.sjsu.cmpe272.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.sjsu.cmpe272.model.User;
import io.sjsu.cmpe272.model.Department;
import io.sjsu.cmpe272.model.DeptEmployee;
import io.sjsu.cmpe272.model.DeptManager;
import io.sjsu.cmpe272.model.Employee;
import io.sjsu.cmpe272.model.Salary;
import io.sjsu.cmpe272.model.Title;
import io.sjsu.cmpe272.repository.UserRepository;
import io.sjsu.cmpe272.repository.DepartmentRepository;
import io.sjsu.cmpe272.repository.DeptEmployeeRepository;
import io.sjsu.cmpe272.repository.DeptManagerRepository;
import io.sjsu.cmpe272.repository.EmployeeRepository;
import io.sjsu.cmpe272.repository.SalaryRepository;
import io.sjsu.cmpe272.repository.TitleRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private TitleRepository titleRepository;
    
    @Autowired
    private SalaryRepository salaryRepository;
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private DeptEmployeeRepository deptEmployeeRepository;
    
    @Autowired
    private DeptManagerRepository deptManagerRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public Employee findEmployeeByEmpNo(int empNo) {
        return employeeRepository.findByEmpNo(empNo);
    }
    
    @Override
    public List<Title> findTitleByEmpNo(int empNo) {
    	return titleRepository.findByEmpNo(empNo);
    }
    
    @Override
    public List<Salary> findSalaryByEmpNo(int empNo) {
    	return salaryRepository.findByEmpNo(empNo);
    } 
    
    @Override
    public Department findDepartmentByEmpNo(int empNo) {
    	DeptEmployee deptEmployee = deptEmployeeRepository.findByEmpNo(empNo);
    	String deptNo = deptEmployee.getDeptNo();
    	return departmentRepository.findByDeptNo(deptNo);
    } 
    
    @Override
    public List<DeptManager> findDeptManagerByDeptNo(String DeptNo) {
    	return deptManagerRepository.findByDeptNo(DeptNo);	
    }
    
//    @Override
//    public User findById(int userId) {
//    	return userRepository.findById(userId);
//    }
    
	@Override
	public void save(User user) {
		user.setEmployee(user.getEmployee());
		user.setUsername(user.getUsername());
		userRepository.save(user);
	}
}

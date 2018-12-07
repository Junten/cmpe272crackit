package io.sjsu.cmpe272.service;

import io.sjsu.cmpe272.model.User;
import io.sjsu.cmpe272.model.Title;
import io.sjsu.cmpe272.model.Salary;
import io.sjsu.cmpe272.model.Department;
import io.sjsu.cmpe272.model.DeptManager;
import io.sjsu.cmpe272.model.Employee;

import java.util.List;

public interface UserService {  
	void save(User user);
//	User findById(int userId);
    User findByUsername(String username);
    Employee findEmployeeByEmpNo(int empNo);
    List<Title> findTitleByEmpNo(int empNo);
    List<Salary> findSalaryByEmpNo(int empNo);
    Department findDepartmentByEmpNo(int empNo);
    List<DeptManager> findDeptManagerByDeptNo(String DeptNo);
}

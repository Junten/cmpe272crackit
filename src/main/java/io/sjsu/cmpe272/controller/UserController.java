package io.sjsu.cmpe272.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.sjsu.cmpe272.model.Employee;
import io.sjsu.cmpe272.model.User;
import io.sjsu.cmpe272.repository.EmployeeAllRepository;
import io.sjsu.cmpe272.repository.EmployeeRepository;
import io.sjsu.cmpe272.repository.UserAllRepository;
import io.sjsu.cmpe272.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired	
	private UserAllRepository userAllRepository;
	
	@Autowired	
	private EmployeeAllRepository employeeAllRepository;
	
	@Autowired	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public UserController(UserAllRepository userAllRepository) {
        this.userAllRepository = userAllRepository;
    }
	
	@PreAuthorize("hasAuthority('Admin')")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
    public DataTablesOutput<User> getUsers(DataTablesInput input) {
        return userAllRepository.findAll(input);
    }
	
	@PreAuthorize("hasAuthority('Admin')")
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
    public DataTablesOutput<Employee> getEmployees(DataTablesInput input) {
		return employeeAllRepository.findAll(input);
	}
	
	@PreAuthorize("hasAuthority('Admin')")
	@DeleteMapping("/user/delete/{userId}")
	public String deleteUser(@PathVariable int userId) {
		try {
			userRepository.deleteById(userId);
		} catch (Exception e) {
			return "Cannot Delete this User ID = " + userId + "<br/> Error Message: " + e;
		}
		return "Success Deleted";
	}
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping("/user/add/{username}/{empNo}")
	public String addUser(@PathVariable("username") String username, @PathVariable("empNo") int empNo) {
		try {
			User user = new User();
			Employee employee = new Employee();
			employee = employeeRepository.findByEmpNo(empNo);
			user.setUsername(username);
			user.setEmployee(employee);
			user.setPassword("password");
			userRepository.save(user);
		} catch (Exception e) {
			return "Cannot Add this Username = " + empNo + "<br/> Error Message: " + e;
		}
		return "Success Added";
	}
	
}

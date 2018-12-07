package io.sjsu.cmpe272.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Lists;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

import io.sjsu.cmpe272.model.Department;
import io.sjsu.cmpe272.model.DeptManager;
import io.sjsu.cmpe272.model.Employee;
import io.sjsu.cmpe272.model.Salary;
import io.sjsu.cmpe272.model.Title;
import io.sjsu.cmpe272.model.User;
import io.sjsu.cmpe272.repository.UserRepository;
import io.sjsu.cmpe272.service.UserService;
import io.sjsu.cmpe272.validator.UserValidator;

@Controller
public class AppController {

	@Autowired
    private UserService userService;
	
	@Autowired
    private UserValidator userValidator;
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
	
	@PreAuthorize("hasAuthority('Admin')")
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		return "signup";
	}
	
	@PreAuthorize("hasAuthority('Admin')")
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
            return "signup";
        }
        userService.save(userForm);
		return "redirect:/home/allusers";
	}
	
	@PreAuthorize("hasAnyAuthority('Admin', 'User')")
	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model, Authentication authentication) {
		
		String username = authentication.getName();
		
		User user = userService.findByUsername(username);
		int empNo = user.getEmployee().getEmpNo();

		List<Title> titleList = userService.findTitleByEmpNo(empNo);	
		
		model.addAttribute("employee", user.getEmployee());
		model.addAttribute("titleList", titleList);
		model.addAttribute("username", username);
		return "home";
    }
	
	@PreAuthorize("hasAnyAuthority('Admin', 'User')")
	@RequestMapping(value = "/home/manager", method = RequestMethod.GET)
	public String manager(Model model, Authentication authentication) {
		String username = authentication.getName();
		
		User user = userService.findByUsername(username);
		int empNo = user.getEmployee().getEmpNo();
		Department department = userService.findDepartmentByEmpNo(empNo);
		List<DeptManager> deptManagerList = userService.findDeptManagerByDeptNo(department.getDeptNumber());
		List<Employee> managerList = new ArrayList<>();
		for (DeptManager deptManager:deptManagerList) {
			Employee manager = userService.findEmployeeByEmpNo(deptManager.getEmpNo());
			managerList.add(manager);
		}
		model.addAttribute("employee", user.getEmployee());
		model.addAttribute("managerList", managerList);
		return "manager";
	}

	@PreAuthorize("hasAnyAuthority('Admin', 'User')")
	@RequestMapping(value = "/home/salary", method = RequestMethod.GET)
	public String salary(Model model, Authentication authentication) {
		String username = authentication.getName();
		
		User user = userService.findByUsername(username);
		int empNo = user.getEmployee().getEmpNo();
		List<Salary> salaryList = userService.findSalaryByEmpNo(empNo);
		
		model.addAttribute("employee", user.getEmployee());
		model.addAttribute("salaryList", Lists.reverse(salaryList));
		return "salary";
	}
	
	@PreAuthorize("hasAnyAuthority('Admin', 'User')")
	@RequestMapping(value = "/home/department", method = RequestMethod.GET)
	public String department(Model model, Authentication authentication) {
		String username = authentication.getName();
		
		User user = userService.findByUsername(username);
		int empNo = user.getEmployee().getEmpNo();
		Department department = userService.findDepartmentByEmpNo(empNo);
		
		model.addAttribute("employee", user.getEmployee());
		model.addAttribute("department", department);
		return "department";
	}

	@PreAuthorize("hasAuthority('Admin')")
	@RequestMapping(value = "/home/allusers", method = RequestMethod.GET)
	public String allusers(Model model, Authentication authentication) {
		String username = authentication.getName();
		
		User user = userService.findByUsername(username);
		model.addAttribute("employee", user.getEmployee());
		model.addAttribute("employee", user.getEmployee());
		return "allusers";
	}
	
	@PreAuthorize("hasAuthority('Admin')")
	@RequestMapping(value = "/home/allemployees", method = RequestMethod.GET)
	public String allemployees(Model model, Authentication authentication) {
		String username = authentication.getName();
		
		User user = userService.findByUsername(username);
		model.addAttribute("employee", user.getEmployee());
		return "allemployees";
	}
}

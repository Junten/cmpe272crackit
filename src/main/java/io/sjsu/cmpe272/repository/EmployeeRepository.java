package io.sjsu.cmpe272.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.sjsu.cmpe272.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	Employee findByEmpNo(int empNo);
	List<Employee> findAll();
}
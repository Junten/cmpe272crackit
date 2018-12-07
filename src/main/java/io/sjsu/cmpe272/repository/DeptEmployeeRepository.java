package io.sjsu.cmpe272.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.sjsu.cmpe272.model.DeptEmployee;

public interface DeptEmployeeRepository extends JpaRepository<DeptEmployee, String> {
	DeptEmployee findByEmpNo(int empNo);
}

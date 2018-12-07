package io.sjsu.cmpe272.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.sjsu.cmpe272.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {
	Department findByDeptNo(String deptNo);
}

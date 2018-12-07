package io.sjsu.cmpe272.repository;

import java.util.List;

import io.sjsu.cmpe272.model.Salary;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, String> {
	List<Salary> findByEmpNo(int empNo);
}

package io.sjsu.cmpe272.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import io.sjsu.cmpe272.model.Employee;

public interface EmployeeAllRepository extends DataTablesRepository<Employee, Integer> {

}

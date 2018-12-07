package io.sjsu.cmpe272.repository;

import io.sjsu.cmpe272.model.Employee;
import io.sjsu.cmpe272.model.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	void deleteByUsername(String username);
    User findByUsername(String username);
    List<User> findAll();
    User findByEmployee(Employee employee);
}
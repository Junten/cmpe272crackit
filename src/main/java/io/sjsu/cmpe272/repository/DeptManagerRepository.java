package io.sjsu.cmpe272.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.sjsu.cmpe272.model.DeptManager;

public interface DeptManagerRepository extends JpaRepository<DeptManager, String> {
	List<DeptManager> findByDeptNo(String DeptNo);
}

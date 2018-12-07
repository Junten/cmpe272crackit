package io.sjsu.cmpe272.repository;

import java.util.List;

import io.sjsu.cmpe272.model.Title;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title, String> {
	List<Title> findByEmpNo(int empNo);
}

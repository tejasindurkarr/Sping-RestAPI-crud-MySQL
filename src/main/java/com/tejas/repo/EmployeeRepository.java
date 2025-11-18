package com.tejas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejas.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	List<Employee> findByName(String name);
}

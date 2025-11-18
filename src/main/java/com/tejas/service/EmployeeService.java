package com.tejas.service;

import java.util.List;
import java.util.Map;

import com.tejas.dto.EmployeeDto;
import com.tejas.entity.Employee;

public interface EmployeeService {

	String saveEmployee(Employee employee);
	
    //Employee getById(int id);
	
	EmployeeDto getById(int id);    //using Dto data transfer object

	List<Employee> getAllEmp();
	
	//updateEmp
	
	String updateEmp(int id,Employee emp);
	
	String updateDep(int id, Map<String, String> dep);
	
	String updateDepAndSalary(int id, Map<String, Object> dep);
	
	
	// Delete
	
	String deleteById(int id);
	
	
	//Custom methods
	
	List<Employee> findByName(String name);
}

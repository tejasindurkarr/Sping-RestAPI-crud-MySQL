package com.tejas.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejas.dto.EmployeeDto;
import com.tejas.entity.Employee;
import com.tejas.repo.EmployeeRepository;
import com.tejas.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
    @Override
	public String saveEmployee(Employee employee) {
		
		employeeRepository.save(employee);
		
		return "Employee Saved Successfully";
		
	}

	@Override
	public EmployeeDto getById(int id) {
		
		Optional<Employee> opemp = employeeRepository.findById(id);
		if(opemp.isPresent())
		{
			Employee employee = opemp.get();
			
			EmployeeDto empDto = new EmployeeDto();
			empDto.setId(employee.getId());
			empDto.setName(employee.getName());
			empDto.setSalary(employee.getSalary());
			empDto.setDep(employee.getDep());
			
			return empDto;
		}
		throw new EmployeeNotFoundException("Employee not found ");
	}

	
	//************ update Employee using Put is update hole object
	
	@Override
	public String updateEmp(int id, Employee emp) {
		
		Optional<Employee> existing = employeeRepository.findById(id);
		
		if(existing.isPresent())
		{
			Employee existingEmployee = existing.get();
			
			existingEmployee.setDep(emp.getDep());
			existingEmployee.setName(emp.getName());
			existingEmployee.setSalary(emp.getSalary());
			
			employeeRepository.save(existingEmployee);
		}
		return "Employee Update Sucessfully";
	}

	
	//************ update Employee using patch method it update single things in object
	
	@Override
	public String updateDep(int id, Map<String, String> dep) {
		
		Optional<Employee> existing = employeeRepository.findById(id);
		
		if(existing.isPresent())
		{
			Employee employee=existing.get();
			employee.setDep(dep.get("dep"));
			
			employeeRepository.save(employee);
		}
		
		return "Employee Dep Update Succes";
	}

	@Override
	public String updateDepAndSalary(int id, Map<String, Object> dep) 
	{
		
		Optional<Employee> existing= employeeRepository.findById(id);
		if(existing.isPresent())
		{
			Employee employee = existing.get();
			employee.setDep((String) dep.get("dep"));
			employee.setSalary((Double) dep.get("salary"));
			
			employeeRepository.save(employee);
			
		}
		
		// TODO Auto-generated method stub
		return "Employee Dep and Salary Update Success";
	}

	//**********Delete method***********
	
	@Override
	public String deleteById(int id) {
		
		boolean existsById = employeeRepository.existsById(id);
		
		if(existsById) {
			
			employeeRepository.deleteById(id);
		}else {
			throw new EmployeeNotFoundException("Employee not found : "+id);
		}
		// TODO Auto-generated method stub
		return "Delete Success";
	}
	
	
	
	//*********** Custom Methods**********
	@Override
	public List<Employee> findByName(String name)
	{
		List<Employee> employees =employeeRepository.findByName(name);
		
		return employees;
	}

	//***** get all employee
	
	@Override
	public List<Employee> getAllEmp() {
		
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
	

}

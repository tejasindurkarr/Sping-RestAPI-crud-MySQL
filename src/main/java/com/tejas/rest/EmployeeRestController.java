package com.tejas.rest;
import com.tejas.service.EmployeeService;
import com.tejas.service.impl.EmployeeServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.dto.EmployeeDto;
import com.tejas.entity.Employee;
import com.tejas.repo.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	
	@Autowired
	EmployeeService employeeService;

	
	
	//****** Custom methods*********
	@GetMapping("/findbyname/{name}")
	public ResponseEntity<List<Employee>> findByName(@PathVariable String name)
	{
		List<Employee> employees = employeeService.findByName(name);
		
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/findall")
	public ResponseEntity<List<Employee>> findAll()
	{
		List<Employee> employees = employeeService.getAllEmp();
		
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	
	
	// ******* Delete methods 
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteByid(@PathVariable int id){
		
		String msg = employeeService.deleteById(id);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ******* Update methods 
	
	//localhost:8080/employee/update/3
	//Putmapping is used to update hole employee
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable int id,@RequestBody Employee employee)
	{
		String msg = employeeService.updateEmp(id, employee);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	
	//patchMaping is used to update single value in object
//	@PatchMapping("/update/dep/{id}")
//	public ResponseEntity<String> update(@PathVariable int id,@RequestBody Map<String, String> dep)
//	{
//		String msg = employeeService.updateDep(id, dep);
//		
//		return new ResponseEntity<String>(msg, HttpStatus.OK);
//	}
	
	
	
	//******* Update dep and salary both  ********
	
	@PatchMapping("/update/dep/salary/{id}")
	public ResponseEntity<String> update(@PathVariable int id,@RequestBody Map<String, Object> dep)
	{
		String msg = employeeService.updateDepAndSalary(id, dep);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	
	
	
	
	// ******* save methods 
	
 	
	//localhost:8080/employee/save
	//@PostMapping("/save")
//	public String saveEmployee(Employee employee) 
//	{
//		 String msg=employeeService.saveEmployee(employee);
//		 
//		 return msg;
//	}
	
	
	@GetMapping("/byid2")
	public ResponseEntity<EmployeeDto> getById(@RequestParam int id)
	{
		EmployeeDto employee = employeeService.getById(id);
		return new ResponseEntity<EmployeeDto>(employee,HttpStatus.OK);
	}
	
	
	
	//localhost:8080/employee/byid/2
	@GetMapping("/byid/{id}")
	public ResponseEntity<EmployeeDto> getById2(@PathVariable int id)
	{
		EmployeeDto employee = employeeService.getById(id);
		return new ResponseEntity<EmployeeDto>(employee,HttpStatus.OK);
	}
	
	
	
	//localhost:8080/employee/save
		@PostMapping("/save")
		public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) 
		{
			 String msg=employeeService.saveEmployee(employee);
			 
			 return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}

}

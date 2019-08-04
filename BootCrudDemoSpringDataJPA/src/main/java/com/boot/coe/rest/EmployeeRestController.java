package com.boot.coe.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.coe.entity.Employee;
import com.boot.coe.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService pEmployeeService)
	{
		employeeService = pEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		List<Employee> list = employeeService.findAll();
		
		return list;
	}
	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable int id){
		
		
		Employee findById = employeeService.findById(id);
		if(findById==null)
			throw new RuntimeException( "No SUch Employee exist");
		return findById;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
		emp.setId(0);
		employeeService.save(emp);
		return emp;
	}
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		//emp.setId(0);
		employeeService.save(emp);
		return emp;
	}
	@DeleteMapping("/employees/{id}")
	public String deleteById(@PathVariable int id){
		Employee findById = employeeService.findById(id);
		if(findById==null)
			throw new RuntimeException( "No SUch Employee exist");
		employeeService.deleteById(id);
		return "Employee Deleted";
	}

}

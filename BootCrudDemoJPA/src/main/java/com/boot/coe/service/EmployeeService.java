package com.boot.coe.service;

import java.util.List;

import com.boot.coe.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(int pId);

	public void save(Employee pEmployee);

	public void deleteById(int pId);

}

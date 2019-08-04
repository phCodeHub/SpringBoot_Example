package com.boot.coe.dao;

import java.util.List;

import com.boot.coe.entity.Employee;

public interface EmployeeDao {
	public List<Employee> findAll();

	public Employee findById(int pId);

	public void save(Employee pEmployee);

	public void deleteById(int pId);
}

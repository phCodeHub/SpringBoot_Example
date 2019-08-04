package com.boot.coe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.coe.dao.EmployeeDao;
import com.boot.coe.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao empDao;
	
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDaoJPAImpl") EmployeeDao empDao) {
		this.empDao = empDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return empDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int pId) {
		return empDao.findById(pId);
	}

	@Override
	@Transactional
	public void save(Employee pEmployee) {
		empDao.save(pEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int pId) {
		empDao.deleteById(pId);
	}

}

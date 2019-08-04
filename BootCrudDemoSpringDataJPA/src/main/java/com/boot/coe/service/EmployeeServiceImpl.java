package com.boot.coe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.coe.dao.EmployeeRepository;
import com.boot.coe.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository repo;
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository pRepo) {
		this.repo = pRepo;
	}

	@Override
	//@Transactional - provided by jparepository
	public List<Employee> findAll() {
		return repo.findAll();
	}

	@Override
	public Employee findById(int pId) {
		Optional<Employee> result = repo.findById(pId);
		Employee temployee = null;
		if(result.isPresent()) {
			temployee = result.get();
		}
		return temployee;
	}

	@Override
	public void save(Employee pEmployee) {
		repo.save(pEmployee);
	}

	@Override
	public void deleteById(int pId) {
		repo.deleteById(pId);
	}

}

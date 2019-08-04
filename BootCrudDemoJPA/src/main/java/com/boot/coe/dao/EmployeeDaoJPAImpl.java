package com.boot.coe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.coe.entity.Employee;


@Repository
public class EmployeeDaoJPAImpl implements EmployeeDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoJPAImpl(EntityManager entityManager) {
		//super();
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Query createQuery = entityManager.createQuery("from Employee");
		List<Employee> resultList = createQuery.getResultList();
		return resultList;
	}

	@Override
	public Employee findById(int pId) {
		Employee employee = entityManager.find(Employee.class, pId);
		return employee;
	}

	@Override
	public void save(Employee pEmployee) {
		Employee employee = entityManager.merge(pEmployee);
		pEmployee.setId(employee.getId());
	}

	@Override
	public void deleteById(int pId) {
		Query createQuery = entityManager.createQuery("delete from Employee where id = :empId");
		createQuery.setParameter("empId", pId);
		createQuery.executeUpdate();
	}

}

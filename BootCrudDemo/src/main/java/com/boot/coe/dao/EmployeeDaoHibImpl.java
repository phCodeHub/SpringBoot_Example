package com.boot.coe.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.boot.coe.entity.Employee;

@Repository

public class EmployeeDaoHibImpl implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoHibImpl(EntityManager pEntityManager) {
		entityManager = pEntityManager;

	}

	@Override
	//@Transactional -- moved to Service
	public List<Employee> findAll() {
		Session lSession = entityManager.unwrap(Session.class);

		Query<Employee> query = lSession.createQuery("from Employee", Employee.class);

		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee findById(int pId) {

		Session currentSessin = entityManager.unwrap(Session.class);
		Employee employee = currentSessin.get(Employee.class, pId);
		return employee;
	}

	@Override
	public void save(Employee pEmployee) {
		Session currentSessin = entityManager.unwrap(Session.class);
		currentSessin.saveOrUpdate(pEmployee);
	}

	@Override
	public void deleteById(int pId) {
		Session currentSessin = entityManager.unwrap(Session.class);
		Query createQuery = currentSessin.createQuery("delete from Employee where id =:employeeId ");
		createQuery.setParameter("employeeId", pId);
		createQuery.executeUpdate();
	}

}

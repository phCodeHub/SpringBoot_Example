package com.boot.coe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.boot.coe.entity.Employee;
/*
 * by default Spring data rest will create endpoint by name plural of Entity defined in interface e.g Employee -> /employees
 * @RepositoryRestResource is used to customise default endpoint name
 * 
 */
//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

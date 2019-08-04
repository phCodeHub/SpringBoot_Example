package com.boot.coe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.coe.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

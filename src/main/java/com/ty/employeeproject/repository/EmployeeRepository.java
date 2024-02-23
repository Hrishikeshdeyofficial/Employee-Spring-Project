package com.ty.employeeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.employeeproject.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
	
	
}

package com.ty.employeeproject.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.employeeproject.entity.Employee;
import com.ty.employeeproject.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}
	
	public Employee getEmployeeById(int id)
	{
			Optional<Employee> optional = employeeRepository.findById(id);
			
			if(optional.isPresent())
			{
				return optional.get();
			}
			else
			{
				return null;
			}
	}
}

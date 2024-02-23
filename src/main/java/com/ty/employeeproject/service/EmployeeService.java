package com.ty.employeeproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.employeeproject.dao.EmployeeDao;
import com.ty.employeeproject.dto.ResponseStructure;
import com.ty.employeeproject.entity.Employee;
import com.ty.employeeproject.exceptionhandler.IdNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		Employee recievedEmployee = employeeDao.saveEmployee(employee);

		ResponseStructure<Employee> response = new ResponseStructure<Employee>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Success");
		response.setData(recievedEmployee);

		return new ResponseEntity<ResponseStructure<Employee>>(response, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Employee>> getAllEmployee(int id) {
	
		Employee employee = employeeDao.getEmployeeById(id);
		if(employee!=null)
		{
		ResponseStructure<Employee> response = new ResponseStructure<Employee>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(employee);
		return new ResponseEntity<ResponseStructure<Employee>>(response, HttpStatus.CREATED);
		}
		
		else
		{
			throw new IdNotFoundException();
		}

		

	}

}

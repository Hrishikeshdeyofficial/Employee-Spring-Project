package com.ty.employeeproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.employeeproject.dto.ResponseStructure;
import com.ty.employeeproject.entity.Employee;
import com.ty.employeeproject.service.EmployeeService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	

	@ApiResponses(value = @ApiResponse(description = "User Created", responseCode = "201"))
	@PostMapping("/employees")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployees(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/getallemployeebyid/{id}")
	public ResponseEntity<ResponseStructure<Employee>> getEmployeeById(@PathVariable int id)
	{
		return employeeService.getAllEmployee(id);
	}
}

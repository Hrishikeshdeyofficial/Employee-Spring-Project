package com.ty.employeeproject.exceptionhandler;

public class IdNotFoundException extends RuntimeException {

	private String message = "Id not found";
	
	public String getMessage()
	{
		return message;
	}
}

package com.jsp.emp.exception;

public class EmployeeNotFoundByNameException extends RuntimeException{

	private String message;

	public EmployeeNotFoundByNameException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
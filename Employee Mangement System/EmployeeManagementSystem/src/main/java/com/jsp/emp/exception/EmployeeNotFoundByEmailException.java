package com.jsp.emp.exception;

public class EmployeeNotFoundByEmailException extends RuntimeException{

	private String message;

	public EmployeeNotFoundByEmailException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
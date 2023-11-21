package com.jsp.emp.exception;

public class EmployeeNotFoundByPhonoNumberException extends RuntimeException{

	private String message;

	public EmployeeNotFoundByPhonoNumberException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
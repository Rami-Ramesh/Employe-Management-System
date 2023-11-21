package com.jsp.emp.exception;

public class DatabaseEmptyException extends RuntimeException
{

	private String message;

	public DatabaseEmptyException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() 
	{
		return message;
	}
	
}

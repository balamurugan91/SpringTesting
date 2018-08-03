package com.spring.test.exceptions;

public class ValidationException extends RuntimeException {

	/**
	 *  New exception for catching the Request parameters validation 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ValidationException(String message)
	{
		super(message);
	}
	
}

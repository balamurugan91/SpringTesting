package com.spring.test.exception;

public class ServerSideValidationException extends Exception {

	/**
	 *  Exception to catch the Server Side Validation
	 */
	private static final long serialVersionUID = 5190633075198845894L;

	public ServerSideValidationException(String message) {
		super(message);
	}
	
	public ServerSideValidationException() {
		super();
	}
	
}

package com.spring.test.exceptions.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.test.exceptions.ValidationException;

@ControllerAdvice
public class GlobalValidationExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = { ValidationException.class })
	protected ResponseEntity<Object> handleConflict(Exception e,WebRequest request) {
		String bodyOfResponse = "This should be application specific";
		
		System.out.println("inside exception handler");
		System.out.println(e.getMessage());
		
		return handleExceptionInternal(e, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	
	
	/*@ExceptionHandler(value = { ValidationException.class })
	public String handleConflict(Exception e) {
		String bodyOfResponse = "This should be application specific";
		
		System.out.println("inside exception handler");
		System.out.println(e.getMessage());
		
		return e.getMessage();
	}*/

	
}
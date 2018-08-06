package com.spring.test.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.test.exception.ServerSideValidationException;

@ControllerAdvice
public class ServerSideValidationExceptionHandler {

	@ExceptionHandler(ServerSideValidationException.class)
	public @ResponseBody String serverSideValidationException(final ServerSideValidationException e) {
		return e.getMessage();
	}

}

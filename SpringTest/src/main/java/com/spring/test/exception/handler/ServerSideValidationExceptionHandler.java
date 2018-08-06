package com.spring.test.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.test.exception.ServerSideValidationException;

@ControllerAdvice
public class ServerSideValidationExceptionHandler {

	@ExceptionHandler(ServerSideValidationException.class)
	public RedirectView serverSideValidationException(final ServerSideValidationException e) {
		RedirectView rv = new RedirectView("errorPage");
		
		rv.setStatusCode(HttpStatus.BAD_REQUEST);
		
		return new RedirectView("errorPage");
	}

}

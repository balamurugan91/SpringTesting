package com.spring.test.annotations.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.spring.test.annotations.ReplaceSingleQuote;

public class ReplaceSingleQuoteImplementation implements ConstraintValidator<ReplaceSingleQuote, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}

}

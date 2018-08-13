package com.spring.test.annotation.impl;

import com.spring.test.constants.Constants;

public class PhoneNumberImplementation {

	public static boolean validate(Object value, boolean allowEmpty)
	{
		
		if (value == null || value.equals("")) {
			if (allowEmpty)
				return true;
			else
				return false;
		} else {
			
			if( value.toString().length() < Constants.phoneNumberMinLength || 
				value.toString().length() > Constants.phoneNumberMaxLength ) 
			{
				return false;
			}

			return value.toString().matches("^[ 0-9\\.\\+\\-\\(\\)]*$");
		}
	}
	
}

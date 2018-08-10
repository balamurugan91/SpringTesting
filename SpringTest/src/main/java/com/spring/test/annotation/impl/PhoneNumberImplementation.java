package com.spring.test.annotation.impl;

public class PhoneNumberImplementation {

	public static boolean validate(Object value, boolean allowEmpty)
	{
		if (value == null || value.equals("")) {
			if (allowEmpty)
				return true;
			else
				return false;
		} else {
			return value.toString().matches("^[ 0-9\\.\\+\\-\\(\\)]*$");
		}
	}
	
}

package com.spring.test.annotation.impl;

public class DecimalImplementation {
	
	public static boolean validate(String value, boolean allowEmpty) {
		if(value.equals("") && allowEmpty == true)
			return true;
		else if(value.equals("") && allowEmpty == false)
			return false;
		else
			return value.matches("-?\\d+(\\.\\d+)?");
	}
}

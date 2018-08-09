package com.spring.test.annotation.impl;

public class AllowEmptyImplementation {

	public static boolean validate(boolean allowEmpty, Object value)
	{
		if( ( value == null || value.toString().equals("") ) && allowEmpty == false)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
}

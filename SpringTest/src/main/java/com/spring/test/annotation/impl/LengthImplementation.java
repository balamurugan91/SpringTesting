package com.spring.test.annotation.impl;

public class LengthImplementation {

	public static boolean validate(Object value,int minLength,int maxLength,boolean allowEmpty)
	{
		if( value == null || value.equals("") )
		{
			if(allowEmpty)
				return true;
			else
				return false;
		}
		else
		{
			if(minLength > 0 &&  ( value.toString().length() < minLength ) )
			{
				return false;
			}
			
			if(maxLength > 0 && ( value.toString().length() > maxLength ))
			{
				return false;
			}
		}
		return true;
	}
}

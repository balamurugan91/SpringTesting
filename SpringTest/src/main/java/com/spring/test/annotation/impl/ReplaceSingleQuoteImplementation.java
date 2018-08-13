package com.spring.test.annotation.impl;

public class ReplaceSingleQuoteImplementation {

	public static String implement(Object value)
	{
		if(value == null)
			return null;
		else
			return value.toString().replaceAll("'", "''");
	}
	
}
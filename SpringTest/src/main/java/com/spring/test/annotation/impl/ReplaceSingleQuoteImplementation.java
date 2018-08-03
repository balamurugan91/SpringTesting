package com.spring.test.annotation.impl;

public class ReplaceSingleQuoteImplementation {

	public static String implement(String value)
	{
		return value.replaceAll("'", "''");
	}
	
}

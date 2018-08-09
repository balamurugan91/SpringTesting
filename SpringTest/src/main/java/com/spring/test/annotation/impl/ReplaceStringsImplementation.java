package com.spring.test.annotation.impl;

import java.util.Arrays;

public class ReplaceStringsImplementation {
	
	public static String implement(Object value, String[] replaceStrings)
	{
		if(value == null)
			return null;
		else
			return value.toString().replaceAll(Arrays.toString(replaceStrings),"");
	}

}

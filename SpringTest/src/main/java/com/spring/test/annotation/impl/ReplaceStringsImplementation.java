package com.spring.test.annotation.impl;

import java.util.Arrays;

public class ReplaceStringsImplementation {
	
	public static String implement(String value, String[] replaceStrings)
	{
		return value.replaceAll(Arrays.toString(replaceStrings),"");
	}

}

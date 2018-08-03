package com.spring.test.annotation.impl;

import org.apache.commons.lang.StringUtils;

public class LengthImplementation {

	public static String implement(String value,int length)
	{
		return StringUtils.substring(value, 0,length);
	}
	
}

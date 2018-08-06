package com.spring.test.annotation.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateImplementation {

	public static boolean validate(String value, String format, boolean allowEmpty)
	{
		try {
			
			if(value.equalsIgnoreCase("") && allowEmpty == true)
				return true;
			else if(value.equalsIgnoreCase("") && allowEmpty == false)
				return false;
			else
			{
				new SimpleDateFormat(format).parse(value);
				return true;
			}
			
		} catch (ParseException e) {
			return false;
		}
	}
	
}

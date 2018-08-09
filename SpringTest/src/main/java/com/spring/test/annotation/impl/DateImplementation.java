package com.spring.test.annotation.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateImplementation {

	private static SimpleDateFormat sf;
	
	public static boolean validate(Object value, String format, boolean allowEmpty)
	{
		try {
			
			if( value == null || value.equals("") )
			{
				if(allowEmpty)
					return true;
				else
					return false;
			}
			else
			{
				sf = new SimpleDateFormat(format);
				sf.setLenient(false);
				sf.parse(value.toString());
				
				return true;
			}
			
		} catch (ParseException e) {
			return false;
		}
	}
}

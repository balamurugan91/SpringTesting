package com.spring.test.annotation.impl;

import java.util.Arrays;
import java.util.regex.Pattern;

public class NoSpecialCharactersImplementation {

	public static boolean validate(Object value, String[] allowedSpecialChars, boolean allowEmpty)
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
			if(allowedSpecialChars!=null)
			{
				String specialCharsString = Arrays.toString(allowedSpecialChars);
				return Pattern.compile("[^a-z0-9"+specialCharsString.substring(1, specialCharsString.length()-1)+"]", Pattern.CASE_INSENSITIVE)
					.matcher(value.toString())
					.find();
			}
			else
			{
				return Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE)
						.matcher(value.toString())
						.find();
			}
		}
	}
}
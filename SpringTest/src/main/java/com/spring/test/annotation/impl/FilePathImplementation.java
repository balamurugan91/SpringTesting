package com.spring.test.annotation.impl;

public class FilePathImplementation {

	public static boolean validate(Object value, String[] validPaths, boolean allowEmpty) {
		
		if( value == null || value.equals("") )
		{
			if(allowEmpty)
				return true;
			else
				return false;
		} 
		else 
		{
			String path = value.toString();
			for (String validPath : validPaths) {
				if (path.startsWith(validPath))
					return true;
				else
					continue;
			}
		}
		return false;
	}
}
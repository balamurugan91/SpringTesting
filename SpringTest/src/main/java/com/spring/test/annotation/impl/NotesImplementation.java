package com.spring.test.annotation.impl;

public class NotesImplementation {

	public static boolean valid(Object value, boolean allowEmpty)
	{
		if (value == null || value.equals("")) {
			if (allowEmpty)
				return true;
			else
				return false;
		} else {
			
			return true;
			
		}
	}

}

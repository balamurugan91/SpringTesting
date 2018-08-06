package com.spring.test.annotation.impl;

public class LengthImplementation {

	public static boolean validate(String value,int minLength,int maxLength)
	{
		if(!isBlank(value))
		{
			if(minLength > 0 &&  ( value.length() < minLength ) )
			{
				return false;
			}
			
			if(maxLength > 0 && ( value.length() > maxLength ))
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean isBlank(String str) {
	      int strLen;
	      if (str == null || (strLen = str.length()) == 0) {
	          return true;
	      }
	      for (int i = 0; i < strLen; i++) {
	          if ((Character.isWhitespace(str.charAt(i)) == false)) {
	              return false;
	          }
	      }
	      return true;
	  }
	
	
}

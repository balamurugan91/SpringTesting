package com.spring.test.annotation.impl;

public class LengthImplementation {

	public static boolean validate(String value,int minLength,int maxLength)
	{
		System.out.println(value);
		System.out.println(minLength);
		System.out.println(maxLength);
		
		if(!isBlank(value))
		{
			
			if(minLength > 0 &&  ( value.length() < minLength ) )
			{
				System.out.println("min failed");
				return false;
			}
			
			if(maxLength > 0 && ( value.length() > maxLength ))
			{
				System.out.println("max failed");
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

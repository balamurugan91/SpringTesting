package com.spring.test.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.spring.test.Exception.ServerSideValidationException;
import com.spring.test.annotation.impl.LengthImplementation;
import com.spring.test.annotation.impl.ReplaceSingleQuoteImplementation;
import com.spring.test.annotation.impl.ReplaceStringsImplementation;
import com.spring.test.annotations.Length;
import com.spring.test.annotations.ReplaceSingleQuote;
import com.spring.test.annotations.ReplaceStrings;

public class ValidationUtils {

	public static boolean validateModel(Object obj) throws ServerSideValidationException
	{
		
		for (Field field : obj.getClass().getDeclaredFields()) {
			
			field.setAccessible(true);

			try {

				Object value = field.get(obj);

				for (Annotation annotation : field.getAnnotations()) 
				{

					if(annotation instanceof ReplaceStrings)
					{
						value = ReplaceStringsImplementation.implement(value.toString(), ((ReplaceStrings)annotation).values());
					}
					
					if (annotation instanceof Length) 
					{
						value = LengthImplementation.implement(value.toString(), ((Length)annotation).value());
					}
					
					if (annotation instanceof ReplaceSingleQuote) 
					{
						value = ReplaceSingleQuoteImplementation.implement(value.toString());
					}

				}

				field.set(obj, value);
				
			} catch (IllegalAccessException e) {

				System.out.println(e);
			}
		}

		return true;
	}

}

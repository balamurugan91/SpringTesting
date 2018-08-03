package com.spring.test.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.spring.test.annotations.ReplaceSingleQuote;

public class ValidationUtils {

	public static boolean validateModel(Object obj)
	{
		
		for (Field field : obj.getClass().getDeclaredFields()) {
			
			field.setAccessible(true);

			try {

				Object value;

				for (Annotation annotation : field.getAnnotations()) {

					if (annotation instanceof ReplaceSingleQuote) {

						value = field.get(obj);

						if(value instanceof String)
						{
							if(value != null)
							{
								field.set(obj, ((String)value).replaceAll("'", "''")  );
							}
						}
					}
				
				}

			} catch (IllegalAccessException e) {

				System.out.println(e);
			}
		}

		return true;
	}
	
}

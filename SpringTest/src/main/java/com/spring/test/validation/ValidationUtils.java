package com.spring.test.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.spring.test.annotation.impl.DateImplementation;
import com.spring.test.annotation.impl.DecimalImplementation;
import com.spring.test.annotation.impl.LengthImplementation;
import com.spring.test.annotation.impl.NotNullImplementation;
import com.spring.test.annotation.impl.NumberImplementation;
import com.spring.test.annotation.impl.ReplaceSingleQuoteImplementation;
import com.spring.test.annotation.impl.ReplaceStringsImplementation;
import com.spring.test.annotations.Date;
import com.spring.test.annotations.Decimal;
import com.spring.test.annotations.Length;
import com.spring.test.annotations.NotNull;
import com.spring.test.annotations.Number;
import com.spring.test.annotations.ReplaceSingleQuote;
import com.spring.test.annotations.ReplaceStrings;
import com.spring.test.exception.ServerSideValidationException;

public class ValidationUtils {

	public static boolean validateModel(Object obj) throws ServerSideValidationException
	{
		
		for (Field field : obj.getClass().getDeclaredFields()) {
			
			field.setAccessible(true);

			try {

				Object value = field.get(obj);

				for (Annotation annotation : field.getAnnotations()) 
				{
					
					/* VALIDATION ANNOTATIONS */
					
					if(annotation instanceof NotNull)
					{
						if(!NotNullImplementation.validate(value))
							throw new ServerSideValidationException();
					}
					
					if(annotation instanceof Number)
					{
						if(!NumberImplementation.validate(value.toString(), ((Number)annotation).allowEmpty() ))
							throw new ServerSideValidationException();
					}
					
					if(annotation instanceof Decimal)
					{
						if(!DecimalImplementation.validate(value.toString(), ((Decimal)annotation).allowEmpty() ))
							throw new ServerSideValidationException();
					}
					
					if(annotation instanceof Date)
					{
						if(!DateImplementation.validate(value.toString(), ((Date) annotation).format(), ((Date) annotation).allowEmpty()))
							throw new ServerSideValidationException();
					}
					
					if(annotation instanceof Length) 
					{
						value = LengthImplementation.validate(value.toString(), ((Length)annotation).minLength(), ((Length)annotation).maxLength() );
						throw new ServerSideValidationException();
					}
					
					
					/* MODIFICATION ANNOTATIONS */
					
					if(annotation instanceof ReplaceStrings)
					{
						value = ReplaceStringsImplementation.implement(value.toString(), ((ReplaceStrings)annotation).values());
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

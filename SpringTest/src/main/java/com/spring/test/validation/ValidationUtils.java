package com.spring.test.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.spring.test.annotation.impl.DateImplementation;
import com.spring.test.annotation.impl.DecimalImplementation;
import com.spring.test.annotation.impl.FilePathImplementation;
import com.spring.test.annotation.impl.LengthImplementation;
import com.spring.test.annotation.impl.NoSpecialCharactersImplementation;
import com.spring.test.annotation.impl.NotNullImplementation;
import com.spring.test.annotation.impl.NumberImplementation;
import com.spring.test.annotation.impl.ReplaceSingleQuoteImplementation;
import com.spring.test.annotation.impl.ReplaceStringsImplementation;
import com.spring.test.annotations.Date;
import com.spring.test.annotations.Decimal;
import com.spring.test.annotations.FilePath;
import com.spring.test.annotations.Length;
import com.spring.test.annotations.NoSpecialCharacters;
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
							throw new ServerSideValidationException("NotNull Failed");
					}
					
					if(annotation instanceof Number)
					{
						if(!NumberImplementation.validate(value, ((Number)annotation).allowEmpty() ))
							throw new ServerSideValidationException("Number Failed");
					}
					
					if(annotation instanceof Decimal)
					{
						if(!DecimalImplementation.validate(value, ((Decimal)annotation).allowEmpty() ))
							throw new ServerSideValidationException("Decimal Failed");
					}
					
					if(annotation instanceof Date)
					{
						if(!DateImplementation.validate(value, ((Date) annotation).format(), ((Date) annotation).allowEmpty()))
							throw new ServerSideValidationException("Date Failed");
					}
					
					if(annotation instanceof Length) 
					{
						if(!LengthImplementation.validate(value, ((Length)annotation).minLength(), ((Length)annotation).maxLength(), ((Length)annotation).allowEmpty() ))
							throw new ServerSideValidationException("Length Failed");
					}
					
					if(annotation instanceof FilePath) 
					{
						if(!FilePathImplementation.validate(value.toString(), ((FilePath)annotation).validPaths(), ((FilePath)annotation).allowEmpty() ))
							throw new ServerSideValidationException("FilePath Failed");
					}
					
					if(annotation instanceof NoSpecialCharacters) 
					{
						if(NoSpecialCharactersImplementation.validate(value.toString(), ((NoSpecialCharacters)annotation).allowedCharacters(), ((NoSpecialCharacters)annotation).allowEmpty() ))
							throw new ServerSideValidationException("NoSpecialCharacters Failed");
					}
					
					/* MODIFICATION ANNOTATIONS */
					
					if(annotation instanceof ReplaceStrings)
					{
						value = ReplaceStringsImplementation.implement(value, ((ReplaceStrings)annotation).values());
					}
					
					if (annotation instanceof ReplaceSingleQuote) 
					{
						value = ReplaceSingleQuoteImplementation.implement(value);
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

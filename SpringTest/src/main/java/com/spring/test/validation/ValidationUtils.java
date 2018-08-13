package com.spring.test.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.spring.test.annotation.impl.DateImplementation;
import com.spring.test.annotation.impl.DecimalImplementation;
import com.spring.test.annotation.impl.EMailImplementation;
import com.spring.test.annotation.impl.FilePathImplementation;
import com.spring.test.annotation.impl.FilterImplementation;
import com.spring.test.annotation.impl.LengthImplementation;
import com.spring.test.annotation.impl.NoSpecialCharactersImplementation;
import com.spring.test.annotation.impl.NotNullImplementation;
import com.spring.test.annotation.impl.NumberImplementation;
import com.spring.test.annotation.impl.OrderByDirectionImplementation;
import com.spring.test.annotation.impl.PhoneNumberImplementation;
import com.spring.test.annotation.impl.ReplaceSingleQuoteImplementation;
import com.spring.test.annotation.impl.ReplaceStringsImplementation;
import com.spring.test.annotations.Date;
import com.spring.test.annotations.Decimal;
import com.spring.test.annotations.EMail;
import com.spring.test.annotations.FilePath;
import com.spring.test.annotations.Filter;
import com.spring.test.annotations.Length;
import com.spring.test.annotations.NoSpecialCharacters;
import com.spring.test.annotations.NotNull;
import com.spring.test.annotations.Number;
import com.spring.test.annotations.OrderByDirection;
import com.spring.test.annotations.PhoneNumber;
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
					
					else if(annotation instanceof Number)
					{
						if(!NumberImplementation.validate(value, ((Number)annotation).allowEmpty() ))
							throw new ServerSideValidationException("Number Failed");
					}
					
					else if(annotation instanceof Decimal)
					{
						if(!DecimalImplementation.validate(value, ((Decimal)annotation).allowEmpty() ))
							throw new ServerSideValidationException("Decimal Failed");
					}
					
					else if(annotation instanceof Date)
					{
						if(!DateImplementation.validate(value, ((Date) annotation).format(), ((Date) annotation).allowEmpty()))
							throw new ServerSideValidationException("Date Failed");
					}
					
					else if(annotation instanceof Length) 
					{
						if(!LengthImplementation.validate(value, ((Length)annotation).minLength(), ((Length)annotation).maxLength(), ((Length)annotation).allowEmpty() ))
							throw new ServerSideValidationException("Length Failed");
					}
					
					else if(annotation instanceof FilePath) 
					{
						if(!FilePathImplementation.validate(value, ((FilePath)annotation).validPaths(), ((FilePath)annotation).allowEmpty() ))
							throw new ServerSideValidationException("FilePath Failed");
					}
					
					else if(annotation instanceof NoSpecialCharacters) 
					{
						if(!NoSpecialCharactersImplementation.validate(value, ((NoSpecialCharacters)annotation).allowedCharacters(), ((NoSpecialCharacters)annotation).allowEmpty() ))
							throw new ServerSideValidationException("NoSpecialCharacters Failed");
					}
					
					else if(annotation instanceof EMail) 
					{
						if(!EMailImplementation.validate(value, ((EMail)annotation).allowEmpty()) )
							throw new ServerSideValidationException("EMail Failed");
					}
					
					else if(annotation instanceof PhoneNumber) 
					{
						if(!PhoneNumberImplementation.validate(value, ((PhoneNumber)annotation).allowEmpty()) )
							throw new ServerSideValidationException("PhoneNumber Failed");
					}
					
					else if(annotation instanceof OrderByDirection) 
					{
						if(!OrderByDirectionImplementation.validate(value) )
							throw new ServerSideValidationException("OrderByDirection Failed");
					}
					
					/* MODIFICATION ANNOTATIONS */
					
					else if(annotation instanceof Filter)
					{
						value = FilterImplementation.implement(value);
					}
					
					else if(annotation instanceof ReplaceStrings)
					{
						value = ReplaceStringsImplementation.implement(value, ((ReplaceStrings)annotation).values());
					}
					
					else if (annotation instanceof ReplaceSingleQuote) 
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

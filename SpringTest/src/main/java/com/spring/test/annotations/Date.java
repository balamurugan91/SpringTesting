package com.spring.test.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validate whether the passed String value is in a valid DateFormat.
 * Pass in the the required Date Format along with whether it accepts Empty value ( null or "" ) or not
 *
 * @param  format  default is ddMMyy. It supports all formats supported by SimpleDateFormatter class
 * @param  allowEmpty  default is true
 * @return boolean
 * 
 */

@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Date {

	String format() default "ddMMMyy";
	boolean allowEmpty() default true;
	
}

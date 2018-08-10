package com.spring.test.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validate whether the passed String value is in a valid Number Format. Pass in
 * the String value along with whether it accepts Empty value ( null or "" ) or
 * not.
 * 
 * @param allowEmpty default is true
 * 
 * @return boolean
 *  
 * The possible outcomes of the annotation are :
 * <table border=1>
 * <tbody>
 * <tr>
 * <td>Number String</td>
 * <td>AllowEmpty</td>
 * <td>Expected Output</td>
 * </tr>
 * <tr>
 * <td>null</td>
 * <td>true</td>
 * <td>true</td>
 * </tr>
 * <tr>
 * <td>""</td>
 * <td>true</td>
 * <td>true</td>
 * </tr>
 * <tr>
 * <td>null</td>
 * <td>false</td>
 * <td>false</td>
 * </tr>
 * <tr>
 * <td>1234</td>
 * <td>true</td>
 * <td>true</td>
 * </tr>
 * <tr>
 * <td>asdf</td>
 * <td>true</td>
 * <td>false</td>
 * </tr>
 * <tr>
 * <td>1234.23</td>
 * <td>true</td>
 * <td>false</td>
 * </tr>
 * </tbody>
 * </table>
 * 
 */

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Number {

	boolean allowEmpty() default true;

}

package com.spring.test.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FilePath {
	String[] validPaths() default {"/apps/dsl/ARBATCH/logs/","/apps/ARBATCH/logs/"};
	boolean allowEmpty() default true;
}

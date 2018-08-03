package com.spring.test.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.spring.test.annotations.validator.SQLInjectionSafeConstraintValidator;

@Documented
@Constraint(validatedBy = SQLInjectionSafeConstraintValidator.class)
@Target( { ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInjectionSafe {
    String message() default "{com.spring.test.annotation.SQLInjectionSafe}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
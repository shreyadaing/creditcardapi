package com.creditcard.validators;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = LuhnValidatorCheck.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface LuhnValidator {
	
	String message() default "Please provide a valid credit card number";
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value() default "";
}

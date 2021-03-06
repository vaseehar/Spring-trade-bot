package com.example.springTradeBot.validator;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordMatchValidator.class)
@Retention(RUNTIME)
@Target(TYPE)
public @interface ValidatePasswordMatch {

	String message() default "Passwords dont match";
	
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

	String field();

	String fieldMatch();
}

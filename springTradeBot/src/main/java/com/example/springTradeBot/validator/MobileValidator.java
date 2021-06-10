package com.example.springTradeBot.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springTradeBot.service.RegisterService;

@Component
public class MobileValidator implements ConstraintValidator<MobileConstraint, String>{

	@Autowired
	RegisterService registerService;
	
	@Override
    public void initialize(MobileConstraint mobileConstraint) {
    }
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value.matches("[0-9]+") && registerService.isNewUser(value);
	}

	
}

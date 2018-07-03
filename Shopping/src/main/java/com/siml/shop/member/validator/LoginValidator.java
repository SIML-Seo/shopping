package com.siml.shop.member.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.siml.shop.member.controller.LoginController;

@Component
public class LoginValidator implements Validator{
	@Override
	public boolean supports(Class<?> arg0) {
		return LoginController.class.isAssignableFrom(arg0);
	}
	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
		ValidationUtils.rejectIfEmpty(errors, "passwd", "required");
	}
}

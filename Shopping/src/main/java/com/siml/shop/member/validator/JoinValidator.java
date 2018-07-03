package com.siml.shop.member.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.siml.shop.member.controller.JoinController;
import com.siml.shop.member.dto.MemberDTO;

@Component
public class JoinValidator implements Validator{
	private static final Logger logger = Logger.getLogger(JoinValidator.class);
	
	private static final String idRegExp = "^[a-z][a-z0-9_-]{3,11}$";
	private static final String emailRegExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String phoneRegExp = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
	private Pattern idPattern;
    private Pattern emailPattern;
    private Pattern phonePattern;
    
	public JoinValidator() {
		idPattern = Pattern.compile(idRegExp);
		emailPattern = Pattern.compile(emailRegExp);
		phonePattern = Pattern.compile(phoneRegExp);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		logger.info("Error : is Not supports Class");
		return JoinController.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		MemberDTO dto = (MemberDTO)object;
		if(dto.getId() == null || dto.getId().trim().isEmpty()) {
			logger.info("Error : Id is required");
			errors.rejectValue("id", "required");
		}else {
			Matcher matcher = idPattern.matcher(dto.getId());
			if(!matcher.matches()) {
				logger.info("Error : Id is bad");
				errors.rejectValue("id", "bad");
			}
		}
		
		if(dto.getEmail() == null || dto.getEmail().trim().isEmpty()) {
			logger.info("Error : Email is required");
			errors.rejectValue("email", "required");
		}else {
			Matcher matcher = emailPattern.matcher(dto.getEmail());
			if(!matcher.matches()) {
				logger.info("Error : Email is bad");
				errors.rejectValue("email", "bad");
			}
		}
		
		if(dto.getPhone() == null || dto.getPhone().trim().isEmpty()) {
			logger.info("Error : Phone is required");
			errors.rejectValue("phone", "required");
		}else {
			Matcher matcher = phonePattern.matcher(dto.getPhone());
			if(!matcher.matches()) {
				logger.info("Error : Phone is bad");
				errors.rejectValue("phone", "bad");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "passwd", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPasswd", "required");
		ValidationUtils.rejectIfEmpty(errors, "nickname", "required");
		ValidationUtils.rejectIfEmpty(errors, "address", "required");
		ValidationUtils.rejectIfEmpty(errors, "address2", "required");
		if(!dto.getPasswd().isEmpty()) {
			if(!dto.isPasswdEqual()) {
				logger.info("Error : Passwd is Nomatch with ConfirmPasswd");
				errors.rejectValue("confirmPasswd", "nomatch");
			}
		}
	}

}

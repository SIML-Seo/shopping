package com.siml.shop.member.controller;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siml.shop.member.dto.LoginDTO;
import com.siml.shop.member.service.MemberService;
import com.siml.shop.member.util.MailSenderService;
import com.siml.shop.member.validator.LoginValidator;

@Controller
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Inject
	MemberService memberService;
	@Inject
	LoginValidator validator;
	@Inject
	MailSenderService mailSenderService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(LoginDTO dto, @CookieValue(value = "REMEMBER", required = false)Cookie cookie) {
		if(cookie != null) {
			logger.info("Has Cookie!");
			dto.setId(cookie.getValue());
			dto.setRememberId(true);
		}
		return "member/login";
	}
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(LoginDTO dto, Errors errors, HttpSession session, HttpServletResponse response) {
		validator.validate(dto, errors);
		if(errors.hasErrors()) {
			logger.info("Error!!");
			return "member/login";
		}
		if(memberService.loginCheck(dto, session, response)) {
			logger.info("Sign in Success : Id = " + dto.getId());
			return "redirect:/";
		}else {	
			errors.rejectValue("id", "nomatch");
			logger.info("Passwd Mismatch");
			return "member/login";
		}
	}
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		memberService.logout(session);
		logger.info("Logout Success!");
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value = "login/searchId", produces = "application/text; charset=utf8")
	public String searchId(String nameForId, String emailForId) {
		return mailSenderService.SendId(nameForId, emailForId);
	}
	
	@ResponseBody
	@RequestMapping(value = "login/searchPass",  produces = "application/text; charset=utf8")
	public String searchPass(String nameForPass, String emailForPass, String idForPass) {
		return mailSenderService.SendPw(nameForPass, emailForPass, idForPass);
	}
}

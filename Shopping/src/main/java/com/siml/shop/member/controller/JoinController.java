package com.siml.shop.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siml.shop.member.dto.MemberDTO;
import com.siml.shop.member.service.MemberService;
import com.siml.shop.member.validator.JoinValidator;

@Controller
public class JoinController {
	private static final Logger logger = Logger.getLogger(JoinController.class);
	
	@Inject
	MemberService memberService;
	@Inject
	JoinValidator validator;
	
	@RequestMapping(value = "member/join")
	public String join() {
		return "member/join";
	}
	
	/*@RequestMapping(value = "member/joinForm", method = RequestMethod.GET)
	public String terms() {
		return "redirect:/member/join";
	}*/
	
	@RequestMapping(value = "member/joinForm", method = RequestMethod.POST)
	public String terms(@RequestParam(value = "agree", defaultValue = "false")Boolean agree, MemberDTO dto, 
			Model model, HttpSession session) {
		logger.info("Agree to Terms");
		logger.info("agree : " + agree);
		if(!agree) {
			return "redirect:/member/join";
		}
		model.addAttribute("memberDTO", dto);
		memberService.agreeCheck(session);
		return "member/joinForm";
	}
	
	@RequestMapping(value = "member/joinResult", method = RequestMethod.POST)
	public String joinForm(MemberDTO dto, Errors errors, HttpSession session) {
		validator.validate(dto, errors);
		
		if(errors.hasErrors()) {
			logger.info("Error!!");
			return "member/joinForm";
		}
		
		memberService.insertMember(dto, session);
		logger.info("Sign up ShoppingMall");
		return "redirect:/member/joinResult";
	}
	
	@RequestMapping(value = "member/joinResult", method = RequestMethod.GET)
	public String joinResult() {
		return "member/joinResult";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "member/idCheck")
	public Boolean idCheck(String id) {
		return memberService.idCheck(id);
	}
}

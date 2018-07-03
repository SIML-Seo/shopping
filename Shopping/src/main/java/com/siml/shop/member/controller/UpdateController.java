package com.siml.shop.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siml.shop.member.dto.MemberDTO;
import com.siml.shop.member.service.MemberService;
import com.siml.shop.member.validator.JoinValidator;

@Controller
public class UpdateController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Inject
	MemberService memberService;
	@Inject
	JoinValidator validator;
	
	@RequestMapping("member")
	public String infoPage(Model model, HttpSession session) {
		String loginUser = (String) session.getAttribute("loginUser");
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("point", memberService.viewMember(loginUser).getPoint());
		return "member/info";
	}
	@RequestMapping(value = "member/update/{id}", method = RequestMethod.GET)
	public String updatePage(@PathVariable String id, Model model) {
		MemberDTO dto = memberService.viewMember(id);
		model.addAttribute("memberDTO", dto);
		return "member/update";
	}
	@RequestMapping(value = "member/update/{id}", method = RequestMethod.POST)
	public String updatePage(MemberDTO dto, Errors errors) {
		validator.validate(dto, errors);
		if(errors.hasErrors()) {
			logger.info("Error!!");
			return "member/update";
		}else{
			memberService.updateMember(dto);
			logger.info("Update Success : Id = " + dto.getId());
			return "redirect:/member";
		}
	}
	@RequestMapping(value = "member/delete/{id}", method = RequestMethod.GET)
	public String deletePage(@PathVariable String id, Model model) {
		model.addAttribute("user", id);
		return "member/delete";
	}
	
	@ResponseBody
	@RequestMapping(value = "member/delete/{id}", method = RequestMethod.POST)
	public String deletePage(@PathVariable String id, String passwd, Model model, HttpSession session) {
		logger.info("id = " + id + " passwd = " + passwd);
		if(memberService.deleteMember(id, passwd, session)) {
			logger.info("Delete Success : Id = " + id);
			return "true";
		}else {
			logger.info("Passwd is Mismatch");
			return "false";
		}
	}
}

package com.siml.shop.member.service;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.siml.shop.member.dao.MemberDAO;
import com.siml.shop.member.dto.LoginDTO;
import com.siml.shop.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	MemberDAO dao;
		
	@Override
	public MemberDTO viewMember(String id) {
		return dao.viewMember(id);
	}

	@Override
	public void insertMember(MemberDTO dto, HttpSession session) {
		session.removeAttribute("joinTerms");
		dao.insertMember(dto);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		dao.updateMember(dto);
	}

	@Override
	public boolean deleteMember(String id, String passwd, HttpSession session) {
		boolean result = false;
		if(dao.idPasswdCheck(id, passwd)){
			dao.deleteMember(id);
			session.invalidate();
			result = true;
		}
		return result;
	}

	@Override
	public boolean idCheck(String id) {
		return dao.idCheck(id);
	}

	@Override
	public boolean loginCheck(LoginDTO dto, HttpSession session, HttpServletResponse response) {
		String id = dto.getId();
		String passwd = dto.getPasswd();
		boolean result = dao.idPasswdCheck(id, passwd);
		if(result) {
			session.setAttribute("loginUser", id);
			if(id.equals("master")) {
				session.setAttribute("master", "운영자");
			}
			Cookie rememberId = new Cookie("REMEMBER", id);
			rememberId.setPath("/");
			if(dto.isRememberId()) {
				rememberId.setMaxAge(60*60*24*60);
			}else {
				rememberId.setMaxAge(0);
			}
			response.addCookie(rememberId);
		}
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	@Override
	public MemberDTO findId(String name, String email) {
		return dao.findId(name, email);
	}

	@Override
	public MemberDTO findPasswd(String name, String email, String id) {
		return dao.findPasswd(name, email, id);
	}

	@Override
	public int updatePasswd(String id, String passwd) {
		return dao.updatePasswd(id, passwd);
	}

	@Override
	public void agreeCheck(HttpSession session) {
		session.setAttribute("joinTerms", "agree");
	}

}

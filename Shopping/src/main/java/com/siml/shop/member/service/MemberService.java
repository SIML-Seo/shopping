package com.siml.shop.member.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.siml.shop.member.dto.LoginDTO;
import com.siml.shop.member.dto.MemberDTO;

public interface MemberService {
	public MemberDTO viewMember(String id);
	public void insertMember(MemberDTO dto, HttpSession session);
	public void updateMember(MemberDTO dto);
	public boolean deleteMember(String id, String passwd, HttpSession session);
	
	public void agreeCheck(HttpSession session);
	
	public boolean idCheck(String id);
	public boolean loginCheck(LoginDTO dto, HttpSession session, HttpServletResponse response);
	public void logout(HttpSession session);
	
	public MemberDTO findId(String name, String email);
	public MemberDTO findPasswd(String name, String email, String id);
	public int updatePasswd(String id, String passwd);
}

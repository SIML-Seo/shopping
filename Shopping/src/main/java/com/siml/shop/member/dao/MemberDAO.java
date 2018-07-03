package com.siml.shop.member.dao;

import com.siml.shop.member.dto.MemberDTO;

public interface MemberDAO {
	public MemberDTO viewMember(String id);
	public void insertMember(MemberDTO dto);
	public void updateMember(MemberDTO dto);
	public void deleteMember(String id);
	
	public boolean idCheck(String id);
	public boolean idPasswdCheck(String id, String passwd);
	
	public MemberDTO findId(String name, String email);
	public MemberDTO findPasswd(String name, String email, String id);
	public int updatePasswd(String id, String passwd);
}

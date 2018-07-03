package com.siml.shop.member.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.siml.shop.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	SqlSession sqlSession;
	
	@Override
	public MemberDTO viewMember(String id) {
		return sqlSession.selectOne("member.view", id);
	}

	@Override
	public void insertMember(MemberDTO dto) {
		sqlSession.insert("member.insert", dto);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		sqlSession.update("member.update", dto);
	}

	@Override
	public void deleteMember(String id) {
		sqlSession.delete("member.delete", id);
	}

	@Override
	public boolean idCheck(String id) {
		String idCheck = sqlSession.selectOne("member.idCheck", id);
		return (idCheck == null) ? false : true;
	}

	@Override
	public boolean idPasswdCheck(String id, String passwd) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("passwd", passwd);
		String loginCheck = sqlSession.selectOne("member.loginCheck", map);
		return (loginCheck == null) ? false : true;
	}

	@Override
	public MemberDTO findId(String name, String email) {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("email", email);
		return sqlSession.selectOne("member.findId", map);
	}

	@Override
	public MemberDTO findPasswd(String name, String email, String id) {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("email", email);
		map.put("id", id);
		return sqlSession.selectOne("member.findPasswd", map);
	}

	@Override
	public int updatePasswd(String id, String passwd) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("passwd", passwd);
		return sqlSession.update("member.updatePasswd", map);
	}

}

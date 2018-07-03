package com.siml.shop.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.siml.shop.board.dto.ReplyDTO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ReplyDTO> list(int boardSeq) {
		return sqlSession.selectList("reply.list", boardSeq);
	}

	@Override
	public void insert(ReplyDTO dto) {
		sqlSession.insert("reply.insert", dto);
	}

	/*@Override
	public void update(ReplyDTO dto) {
		sqlSession.update("reply.update", dto);
	}*/

	@Override
	public void delete(int seq) {
		sqlSession.delete("reply.delete", seq);
	}

}

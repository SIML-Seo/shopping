package com.siml.shop.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.siml.shop.board.dto.PagingDTO;
import com.siml.shop.board.dto.QnABoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public void insert(QnABoardDTO dto) {
		sqlSession.insert("board.insert", dto);
	}

	@Override
	public List<QnABoardDTO> list(PagingDTO dto) {
		return sqlSession.selectList("board.list", dto);
	}
	
	@Override
	public int boardCount(PagingDTO dto) {
		return sqlSession.selectOne("board.count", dto);
	}
	
	@Override
	public QnABoardDTO read(int seq) {
		return sqlSession.selectOne("board.read", seq);
	}

	@Override
	public void modify(QnABoardDTO dto) {
		sqlSession.update("board.modify", dto);
	}

	@Override
	public void delete(int seq) {
		sqlSession.delete("board.delete", seq);
	}

	

}

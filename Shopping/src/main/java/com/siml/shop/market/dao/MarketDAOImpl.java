package com.siml.shop.market.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.siml.shop.market.dto.NaverBookDTO;

@Repository
public class MarketDAOImpl implements MarketDAO {
	@Inject
	SqlSession sqlSession;
	
	@Override
	public void sellBook(NaverBookDTO dto) {
		sqlSession.insert("market.sell", dto);
	}
	@Override
	public void buyBook(NaverBookDTO dto) {
		sqlSession.insert("market.buy", dto);
	}

	@Override
	public int countBook() {
		return sqlSession.selectOne("market.count");
	}
	@Override
	public List<NaverBookDTO> bookList() {
		return sqlSession.selectList("market.bookList");
	}
	@Override
	public NaverBookDTO bookInfo(int seq) {
		return sqlSession.selectOne("market.bookInfo", seq);
	}
	@Override
	public List<NaverBookDTO> bookLink(){
		return sqlSession.selectList("market.bookLink");
	}
	@Override
	public List<NaverBookDTO> bookQuery(String cho){
		System.out.println("dao cho : " + cho);
		return sqlSession.selectList("market.bookQuery", cho);
	}
}

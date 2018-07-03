package com.siml.shop.market.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.siml.shop.market.dto.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO {
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<CartDTO> cartMoney() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(CartDTO dto) {
		sqlSession.insert("cart.insert", dto);
	}

	@Override
	public List<CartDTO> cartList(String userId) {
		return sqlSession.selectList("cart.cartList", userId);
	}

	@Override
	public void delete(int seq) {
		sqlSession.delete("cart.delete", seq);
	}

	@Override
	public void deleteAll(String userId) {
		sqlSession.delete("cart.deleteAll", userId);
	}

	@Override
	public int sumMoney(String userId) {
		return sqlSession.selectOne("cart.sumMoney", userId);
	}
	
	/*	@Override
	public void modifyCart(CartDTO dto) {
		sqlSession.update("cart.modifyCart", dto);
	}
	
	@Override
	public void update(int seq) {
		// TODO Auto-generated method stub
	}
	@Override
	public int countCart(String userId, int bookNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCart(CartDTO dto) {
		// TODO Auto-generated method stub
	}*/

}

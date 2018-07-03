package com.siml.shop.market.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.siml.shop.market.dto.OrderDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {
	@Inject
	SqlSession sqlSession;
	
	@Override
	public void insertOrder(OrderDTO dto) {
		sqlSession.insert("order.insert", dto);
	}
	
	@Override
	public List<OrderDTO> orderList(String userId) {
		return sqlSession.selectList("order.orderList", userId);
	}
	
	@Override
	public int pointCheck(String userId) {
		return sqlSession.selectOne("order.pointCheck", userId); 
	}

	@Override
	public void changePoint(String userId, int point) {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("point", point);
		sqlSession.update("order.deductPoint", map);
	}

	@Override
	public void updateBookStatus(String status, int seq) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", status);
		map.put("seq", seq);
		sqlSession.update("order.updateBookStatus", map);
	}

	@Override
	public void updateOrderStatus(String status, String orderNum) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", status);
		map.put("orderNum", orderNum);
		sqlSession.update("order.updateOrderStatus", map);
	}
	
}

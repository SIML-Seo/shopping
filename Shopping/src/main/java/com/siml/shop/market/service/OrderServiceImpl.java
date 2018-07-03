package com.siml.shop.market.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siml.shop.market.dao.OrderDAO;
import com.siml.shop.market.dto.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService {
	@Inject
	OrderDAO dao;
	
	@Override
	public List<OrderDTO> orderList(String userId) {
		return dao.orderList(userId);
	}
	
	@Override
	public void insertOrder(String userId, String bookInfo, int sumPrice) {
		OrderDTO dto = new OrderDTO();
		dto.setUserId(userId);
		dto.setBookInfo(bookInfo);
		dto.setMoney(sumPrice);
		
		String orderNum = Long.toString(System.currentTimeMillis());
		
		dto.setOrderNum(orderNum);
		dao.insertOrder(dto);
	}
	
	@Override
	public int pointCheck(String userId) {
		return dao.pointCheck(userId);
	}
	
	@Transactional
	@Override
	public boolean orderResult(String userId, int sumPrice) {
		int hasPoint = dao.pointCheck(userId);
		int subPoint = hasPoint - sumPrice;
		if(subPoint < 0) {
			return false;
		}else {
			dao.changePoint(userId, subPoint);
			return true;
		}
	}

	@Override
	public void updateBookStatus(String status, int seq) {
		dao.updateBookStatus(status, seq);
	}

	@Transactional
	@Override
	public void updateOrderStatus(String status, OrderDTO dto) {
		dao.updateOrderStatus(status, dto.getOrderNum());
		String bookInfos = dto.getBookInfo();
		for(String bookInfo : bookInfos.split(";")) {
			int seq = Integer.parseInt(bookInfo.split("\\|")[0]);
			updateBookStatus("재고", seq);
		}
		int refundedMoney = dto.getMoney() + pointCheck(dto.getUserId());
		dao.changePoint(dto.getUserId(), refundedMoney);
	}

}

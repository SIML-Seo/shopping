package com.siml.shop.market.service;

import java.util.List;

import com.siml.shop.market.dto.OrderDTO;

public interface OrderService {
	public List<OrderDTO> orderList(String userId);
	public void insertOrder(String userId, String bookInfo, int sumPrice);
	public int pointCheck(String userId);
	public boolean orderResult(String userId, int sumPrice);
	public void updateBookStatus(String status, int seq);
	public void updateOrderStatus(String status, OrderDTO dto);
}

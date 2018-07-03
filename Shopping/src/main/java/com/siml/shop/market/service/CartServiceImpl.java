package com.siml.shop.market.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.siml.shop.market.dao.CartDAO;
import com.siml.shop.market.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService {
	@Inject
	CartDAO dao;
	
	@Override
	public List<CartDTO> cartMoney() {
		return null;
	}
	@Override
	public void insert(String loginUser, int seq) {
		CartDTO dto = new CartDTO();
		dto.setUserId(loginUser);
		dto.setBookNum(seq);
		dao.insert(dto);
	}
	@Override
	public List<CartDTO> cartList(String userId) {
		return dao.cartList(userId);
	}
	@Override
	public void delete(int seq) {
		dao.delete(seq);
	}
	@Override
	public void deleteAll(String userId) {
		dao.deleteAll(userId);
	}
	@Override
	public int sumMoney(String userId) {
		return dao.sumMoney(userId);
	}

}

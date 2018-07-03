package com.siml.shop.market.service;

import java.util.List;

import com.siml.shop.market.dto.CartDTO;

public interface CartService {
	public List<CartDTO> cartMoney();
    public void insert(String LoginUser, int seq);
    public List<CartDTO> cartList(String userId);
    public void delete(int seq);
    public void deleteAll(String userId);
    public int sumMoney(String userId);
}

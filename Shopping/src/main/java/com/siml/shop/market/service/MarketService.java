package com.siml.shop.market.service;

import java.util.List;

import com.siml.shop.market.dto.NaverBookDTO;

public interface MarketService {
	public void sellBook(NaverBookDTO dto);
	public void buyBook(NaverBookDTO dto);
	public int countBook();
	public List<NaverBookDTO> bookList();
	public NaverBookDTO bookInfo(int seq);
	public List<NaverBookDTO> bookLink();
	public List<NaverBookDTO> bookQuery(String cho);
}

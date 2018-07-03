package com.siml.shop.market.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.siml.shop.market.dao.MarketDAO;
import com.siml.shop.market.dto.NaverBookDTO;

@Service
public class MarketServiceImpl implements MarketService {

	@Inject
	MarketDAO dao;
	
	@Override
	public void sellBook(NaverBookDTO dto) {
		dao.sellBook(dto);
	}

	@Override
	public void buyBook(NaverBookDTO dto) {
		dao.buyBook(dto);
	}

	@Override
	public int countBook() {
		return dao.countBook();
	}

	@Override
	public List<NaverBookDTO> bookList() {
		return dao.bookList();
	}

	@Override
	public NaverBookDTO bookInfo(int seq) {
		return dao.bookInfo(seq);
	}
	
	@Override
	public List<NaverBookDTO> bookLink(){
		return dao.bookLink();
	}

	@Override
	public List<NaverBookDTO> bookQuery(String cho) {
		System.out.println("ser cho : " + cho);
		return dao.bookQuery(cho); 
	}
}

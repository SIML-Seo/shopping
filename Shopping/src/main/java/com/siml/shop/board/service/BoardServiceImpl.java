package com.siml.shop.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.siml.shop.board.dao.BoardDAO;
import com.siml.shop.board.dto.PagingDTO;
import com.siml.shop.board.dto.QnABoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO dao;
	
	@Override
	public void insert(QnABoardDTO dto) {
		dao.insert(dto);
	}

	@Override
	public List<QnABoardDTO> list(PagingDTO dto) {
		return dao.list(dto);
	}

	@Override
	public int boardCount(PagingDTO dto) {
		return dao.boardCount(dto);
	}
	
	@Override
	public QnABoardDTO read(int seq) {
		return dao.read(seq);
	}

	@Override
	public void modify(QnABoardDTO dto) {
		dao.modify(dto);
	}

	@Override
	public void delete(int seq) {
		dao.delete(seq);
	}

}

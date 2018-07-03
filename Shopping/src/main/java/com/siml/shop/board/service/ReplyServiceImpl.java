package com.siml.shop.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.siml.shop.board.dao.ReplyDAO;
import com.siml.shop.board.dto.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Inject
	ReplyDAO dao;
	
	@Override
	public List<ReplyDTO> list(int boardSeq) {
		return dao.list(boardSeq);
	}

	@Override
	public void insert(ReplyDTO dto) {
		dao.insert(dto);
	}

	/*@Override
	public void update(ReplyDTO dto) {
		dao.update(dto);
	}*/

	@Override
	public void delete(int seq) {
		dao.delete(seq);
	}

}

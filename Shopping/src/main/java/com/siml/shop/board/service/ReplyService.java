package com.siml.shop.board.service;

import java.util.List;

import com.siml.shop.board.dto.ReplyDTO;

public interface ReplyService {
	public List<ReplyDTO> list(int boardSeq);
	public void insert(ReplyDTO dto);
	/*public void update(ReplyDTO dto);*/
	public void delete(int seq);
}

package com.siml.shop.board.service;

import java.util.List;

import com.siml.shop.board.dto.PagingDTO;
import com.siml.shop.board.dto.QnABoardDTO;

public interface BoardService {
    public void insert(QnABoardDTO dto);
    public List<QnABoardDTO> list(PagingDTO dto); 
    public int boardCount(PagingDTO dto);
    public QnABoardDTO read(int seq);
    public void modify(QnABoardDTO dto);
    public void delete(int seq);
    
}

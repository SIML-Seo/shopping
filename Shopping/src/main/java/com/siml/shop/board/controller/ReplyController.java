package com.siml.shop.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.siml.shop.board.dto.ReplyDTO;
import com.siml.shop.board.service.ReplyService;

@RestController
@RequestMapping("reply/*")
public class ReplyController {
	
	@Inject
	ReplyService service;
	
    @RequestMapping("insert")
    public void insert(ReplyDTO dto, HttpSession session){			//답변이 성공적으로 등록되면
        String userId = (String)session.getAttribute("loginUser");  //게시물 리스트에 답변완료 글 추가되도록 js로 설정
        dto.setReplyWriter(userId);
        service.insert(dto);									
    }

    @ResponseBody
    @RequestMapping("list")
    public List<ReplyDTO> listJson(int boardSeq){
        List<ReplyDTO> list = service.list(boardSeq);
        return list;
    }
    
    @RequestMapping("delete")
    public void delete(int seq) {
    	service.delete(seq);
    }
}

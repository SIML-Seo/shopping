package com.siml.shop.board.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siml.shop.board.dto.PagingDTO;
import com.siml.shop.board.dto.QnABoardDTO;
import com.siml.shop.board.service.BoardService;
import com.siml.shop.board.util.Paging;

@Controller
@RequestMapping("board/*")
public class BoardController {
	private static final Logger logger = Logger.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	@RequestMapping(value = "list")
	public String boardList(PagingDTO dto, Model model) {			//게시물 검색 후 읽기, 수정 이후 목록 버튼 클릭 시 검색 결과 리스트로 돌아가는 방식 구현 실패
		Paging paging = new Paging();								
		paging.setPagingDto(dto);
		paging.setTotalCount(service.boardCount(dto));
		
		model.addAttribute("boardList", service.list(dto));
		model.addAttribute("paging", paging);
		return "board/boardList";
	}
	
	@RequestMapping(value = "read")										
	public String read(int seq, Model model) {
		model.addAttribute("article", service.read(seq));
		return "board/article";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write(HttpSession session, Model model) {
		String userId = (String)session.getAttribute("loginUser");
		model.addAttribute("userId", userId);
		return "board/writeForm";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(QnABoardDTO dto, RedirectAttributes redAtt) {
		service.insert(dto);
		redAtt.addFlashAttribute("result", "write");
		logger.info("Write SUCCESS!!");
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modify(int seq, Model model) {
		model.addAttribute("article", service.read(seq));
		return "board/modify";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(QnABoardDTO dto, RedirectAttributes redAtt) {
		service.modify(dto);
		redAtt.addFlashAttribute("result", "modify");
		logger.info("Modify SUCCESS!!");
		return "redirect:/board/list";
	}

	@RequestMapping(value = "delete")
	public String delete(int seq, RedirectAttributes redAtt) {
		service.delete(seq);
		redAtt.addFlashAttribute("result", "delete");
		logger.info("Delete SUCCESS!!");
		return "redirect:/board/list";
	}
	
}

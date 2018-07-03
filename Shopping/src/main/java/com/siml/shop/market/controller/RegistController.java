package com.siml.shop.market.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siml.shop.market.dto.NaverBookDTO;
import com.siml.shop.market.service.MarketService;
import com.siml.shop.market.util.SearchForTitle;

@Controller
public class RegistController {
	private static final Logger logger = Logger.getLogger(RegistController.class);

	@Inject
	SearchForTitle searchForTitle;
	@Inject
	MarketService marketService;
	
	@RequestMapping(value = "market/searchForm")
	public String serachForm() {
		return "market/search";
	}
	
	@RequestMapping(value = "market/search")
	public ResponseEntity<String> search(String title, String pageNum) {
		ResponseEntity<String> result = searchForTitle.serachResult(title, pageNum);
		logger.info("Search Success!!");
		return result;
	}
	@RequestMapping(value = "market/passForm")
	public ResponseEntity<String> pass(String isbn){
		ResponseEntity<String> result = searchForTitle.serachResult(isbn, "1");
		logger.info("Passing BookData For SellForm Success!!");
		return result;
	}
	
	@RequestMapping(value = "market/sell")
	public String sellForm(){
		return "market/sellForm";
	}

	@RequestMapping(value = "market/sellRegist")
	public String sellRegist(NaverBookDTO dto, RedirectAttributes redAtt) {
		marketService.sellBook(dto);
		redAtt.addFlashAttribute("result", "sell");
		logger.info("Selling Success!!");
		return "redirect:/";
	}
	
	@RequestMapping(value = "market/list")
	public String marketList(Model model) {
		model.addAttribute("list", marketService.bookList());
		return "market/marketList";
	}
	
	@RequestMapping(value = "market/list/{cho}")
	public String marketQuery(@PathVariable String cho, Model model) {
		System.out.println("reg cho : " + cho);
		System.out.println("type : " + cho.getClass());
		model.addAttribute("list", marketService.bookQuery(cho));
		return "market/marketList";
	}
	
	@RequestMapping(value = "market/info/{seq}")
	public String marketInfo(@PathVariable int seq, Model model) {
		model.addAttribute("book", marketService.bookInfo(seq));
		return "market/info";
	}
}

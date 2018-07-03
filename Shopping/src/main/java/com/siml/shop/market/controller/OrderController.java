package com.siml.shop.market.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siml.shop.market.dto.OrderDTO;
import com.siml.shop.market.service.CartService;
import com.siml.shop.market.service.OrderService;

@Controller
@RequestMapping("market/order/*")
public class OrderController {
	private static final Logger logger = Logger.getLogger(OrderController.class);
	
	@Inject
	OrderService service;
	@Inject
	CartService cartService;
	
	@RequestMapping(value = "result")
	public String orderResult(int sumPrice, int[] bookNum, String[] bookImage, Model model, HttpSession session, RedirectAttributes redAtt) {
		String userId = (String) session.getAttribute("loginUser");
		int currentPoint = service.pointCheck(userId);
		String bookInfo = "";
		
		if(service.orderResult(userId, sumPrice)) {
			int deductPoint = currentPoint - sumPrice;
			
			for(int i = 0; i < bookNum.length; i++) {
				service.updateBookStatus("배송", bookNum[i]);
				bookInfo += (bookNum[i] + "|" + bookImage[i] + ";");
			}	
			service.insertOrder(userId, bookInfo, sumPrice);
			cartService.deleteAll(userId);
			model.addAttribute("currentPoint", currentPoint);
			model.addAttribute("sumPrice", sumPrice);
			model.addAttribute("deductPoint", deductPoint);
			logger.info("SUCCESS ORDER!!");
			return "market/orderResult";
		}
		logger.info("Hasn't Enough Point");
		redAtt.addFlashAttribute("result", "lack");
		return "redirect:/market/cart/list";
	}
	
	@RequestMapping("list")
	public String orderList(Model model, HttpSession session) {
		String userId = (String) session.getAttribute("loginUser");
		List<OrderDTO> list = service.orderList(userId);
		model.addAttribute("orderList", list);
		return "market/orderList";
	}
	
	@RequestMapping("cancle")
	public String cancle(OrderDTO dto, HttpSession session, RedirectAttributes redAtt) {
		service.updateOrderStatus("주문취소", dto);
		logger.info("Order Cancle Success!!");
		redAtt.addFlashAttribute("result", "cancle");
		return "redirect:/market/order/list";
	}
	
	@RequestMapping("takeback")
	public String takeback(OrderDTO dto, HttpSession session, RedirectAttributes redAtt) {
		service.updateOrderStatus("반품", dto);
		logger.info("Order Takeback Success!!");
		redAtt.addFlashAttribute("result", "takeback");
		return "redirect:/market/order/list";
	}

}

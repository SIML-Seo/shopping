package com.siml.shop.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siml.shop.market.dto.CartDTO;
import com.siml.shop.market.service.CartService;
import com.siml.shop.member.dto.MemberDTO;
import com.siml.shop.member.service.MemberService;

@Controller
@RequestMapping("market/cart/*")
public class CartController {
	private static final Logger logger = Logger.getLogger(CartController.class);
	
    @Inject
    CartService cartService;
    @Inject
    MemberService memberService;
	
    @RequestMapping("list")
    public String list(HttpSession session, Model model){
        Map<String, Object> map = new HashMap<>();
        String loginUser = (String)session.getAttribute("loginUser");      
        if(loginUser != null){                                            
            List<CartDTO> list = cartService.cartList(loginUser);         
            int sumMoney = cartService.sumMoney(loginUser);
            int fee = sumMoney >= 20000 ? 0 : 3000;
            map.put("list", list);
            map.put("count", list.size());
            map.put("sumMoney", sumMoney);        
            map.put("fee", fee);                 
            map.put("sum", sumMoney + fee);      

            model.addAttribute("map", map);
            return "market/cart";
        }else{
        	logger.info("Isn't LOGIN");
            return "redirect:/";           
        }
    }
    
	@RequestMapping("insert")
	public String insert(int seq, HttpSession session, RedirectAttributes redAtt) {
		String loginUser = (String) session.getAttribute("loginUser");
		if(loginUser == null) {
			logger.info("Isn't LOGIN");
			return "redirect:/";
		}
		cartService.insert(loginUser, seq);	
		logger.info("Insert Book to Cart");
		redAtt.addFlashAttribute("result", "insert");
		return "redirect:/market/list";
//		return "redirect:/market/cart/list";	 	
	}		
	
	@RequestMapping("delete")
	public String delete(int seq, HttpSession session, RedirectAttributes redAtt){
		String loginUser = (String) session.getAttribute("loginUser");
		if(loginUser == null) {
			logger.info("Isn't LOGIN");
			return "redirect:/";
		}
	    cartService.delete(seq);
	    logger.info("Delete Book into Cart");
	    redAtt.addFlashAttribute("result", "delete");
	    return "redirect:/market/cart/list";
	}
	
	@RequestMapping("deleteAll")
	public String deleteAll(HttpSession session, RedirectAttributes redAtt){
		String loginUser = (String) session.getAttribute("loginUser");
		if(loginUser == null) {
			logger.info("Isn't LOGIN");
			return "redirect:/";
		}
	    cartService.deleteAll(loginUser);
	    logger.info("Delete All Book into Cart");
	    redAtt.addFlashAttribute("result", "deleteAll");
	    return "redirect:/market/cart/list";
	}      
	
	@RequestMapping("order")
	public String order(HttpSession session, Model model) {
		 Map<String, Object> map = new HashMap<>();
	        String loginUser = (String)session.getAttribute("loginUser");      
	        if(loginUser != null){
	            List<CartDTO> list = cartService.cartList(loginUser);
	            int sumMoney = cartService.sumMoney(loginUser);
	            int fee = sumMoney >= 20000 ? 0 : 3000;
	            map.put("list", list);
	            map.put("count", list.size());
	            map.put("sumMoney", sumMoney);
	            map.put("fee", fee);
	            map.put("sum", sumMoney + fee);
	            
	            MemberDTO dto = memberService.viewMember(loginUser);
	            map.put("dto", dto);
	            
	            model.addAttribute("map", map);
	            return "market/order";
	        }else{
	        	logger.info("Isn't LOGIN");
	            return "redirect:/";
	        }
	}
}

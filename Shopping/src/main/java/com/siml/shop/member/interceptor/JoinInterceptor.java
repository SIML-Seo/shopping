package com.siml.shop.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class JoinInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = Logger.getLogger(JoinInterceptor.class);

	/**
	 * 회원 가입 시 약관 동의를 누르는 절차를 거치지 않고 곧바로 가입페이지에 접근하는 것을 방지하기 위한 인터셉터
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("joinTerms") == null) {
			logger.info("Don't Agree JoinTerms, Interceptor to joinForm");
			response.sendRedirect(request.getContextPath()+ "/member/join");
			return false;
		}else {
			return true;
		}
	}
	
}

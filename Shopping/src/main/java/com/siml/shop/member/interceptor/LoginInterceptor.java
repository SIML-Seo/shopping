package com.siml.shop.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = Logger.getLogger(JoinInterceptor.class);
	/**
	 * 로그인 없이 페이지에 접근하는 것을 방지하기 위한 인터셉터
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("loginUser") == null) {
			logger.info("Isn't Login, so Start Interceptor");
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}else {
			return true;
		}
	}
}

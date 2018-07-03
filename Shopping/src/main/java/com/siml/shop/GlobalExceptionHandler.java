package com.siml.shop;

import java.sql.SQLException;
import java.util.zip.DataFormatException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
	private static final String DEFAULT_ERROR_VIEW = "/exception";
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView sqlExceptionHandler(HttpServletRequest req, SQLException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e.getClass().getSimpleName());			//e.getClass().getSimpleName() 으로 가능? IOException 등을 표시?
		mav.addObject("message", "데이터 베이스 작업 중 오류가 발생했습니다.");
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		logger.error(e.getMessage());
		return mav;
	}
	
	@ExceptionHandler(DataFormatException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "BAD REQUEST") // 400
    public ModelAndView handleDataFormatException(DataFormatException e, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();								//response로 받았어야했나?
		mav.addObject("exception", e.getClass().getSimpleName());
		mav.addObject("message", "데이터 입력 값이 바람직한 형식이 아닙니다.");
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		logger.error(e.getMessage());
		return mav;
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "NOT FOUND") // 404
    public ModelAndView customException(HttpServletResponse res) {		//마땅한 exception을 찾아야함 = ResourceNotFoundException
		ModelAndView mav = new ModelAndView();							//그러나 responsestatus로 이미 해당 상태 발생시 이 메소드 호출되도록 지정했으므로
		mav.addObject("message", "존재 하지 않는 페이지 입니다");				//exception을 지정할 필요는 없다
		mav.addObject("url", res.getStatus());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
    }
	
	@ExceptionHandler(Exception.class)
	public ModelAndView ExceptionHandler(HttpServletRequest req, Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e.getClass().getSimpleName());
		mav.addObject("message", "기본 최상위 익셉션 실험용");
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		logger.error(e.getMessage());
		return mav;
	}
}
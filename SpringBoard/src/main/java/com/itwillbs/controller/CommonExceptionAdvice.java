package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 *  컨트롤러에서 발생하는 예외를 처리하는 객체 
 * */

@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

	// 예외처리 -> 메서드
	// @ExceptionHandler(NullPointerException.class)
	@ExceptionHandler(Exception.class)
	public String commons(Exception e,Model model) {
		logger.debug(" 예외 발생! ");
		logger.debug("e : " + e);
		
		model.addAttribute("e", e);
		
		return "commons";
	}

}

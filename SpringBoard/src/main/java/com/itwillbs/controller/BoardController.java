package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

	// 서비스 객체 주입
	@Inject
	private BoardService bService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	// 글쓰기GET : /board/register
	// http://localhost:8088/board/register
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		logger.debug("/board/register ->  registerGET() 호출 ");
		logger.debug("/board/register.jsp 뷰 연결");

	}

	
	// 글쓰기POST : /board/register
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String registerPOST(BoardVO vo) throws Exception {
		logger.debug(" /board/regiter.jsp (submit) -> registerPOST() 호출 ");
		
		// 한글처리(필터) 생략
		// 전달정보( 글 정보 ) 저장
		logger.debug(" 전달정보  : "+vo);
		
		// 서비스 -> DAO 글쓰기 동작 호출
		bService.regist(vo);
		
		logger.debug(" 글쓰기 완료! -> 리스트 페이지로 이동 ");
		// 페이지 이동 (list)
		
		return "redirect:/board/list";
	}
	
	
	// 리스트GET : /board/list
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public void listGET(Model model) throws Exception {
		logger.debug(" /board/list -> listGET()실행 ");
		logger.debug(" /board/list.jsp 연결 ");
		// 서비스 -> DAO 게시판 글 목록 가져오기
		List<BoardVO> boardList = bService.getList();
		logger.debug(" list.size : "+boardList.size());
		// 연결된 뷰페이지에 정보 전달(Model)
		model.addAttribute("boardList", boardList);		
	}
	
	
	
	
	
	

}

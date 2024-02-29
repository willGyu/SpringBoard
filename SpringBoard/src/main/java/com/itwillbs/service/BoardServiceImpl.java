package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	// DAO객체 주입
	@Inject
	private BoardDAO bdao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		logger.debug(" regist(BoardVO vo)실행 -> DAO 글쓰기 동작 호출 ");
		
		bdao.boardCreate(vo);
		
		logger.debug(" 서비스 동작완료 -> 컨트롤러 이동 ");
	}

	
	@Override
	public List<BoardVO> getList() throws Exception {
		logger.debug(" getList() 실행 ");
		return bdao.boardListSelect();
	}

	

	@Override
	public BoardVO read(Integer bno) throws Exception {
		logger.debug("  read(Integer bno)  실행 ");
		
		return bdao.boardSelect(bno);
	}


	@Override
	public void updateViewcnt(Integer bno) throws Exception {
		logger.debug(" updateViewcnt(Integer bno)  실행");
		
		bdao.boardViewcntUpdate(bno);
	}


	@Override
	public void modifyBoard(BoardVO vo) throws Exception {
		logger.debug(" modifyBoard(BoardVO vo)  호출 ");
		
		bdao.boardUpdate(vo);
	}


	@Override
	public void removeBoard(int bno) throws Exception {
		logger.debug(" removeBoard(int bno) 호출 ");
		bdao.boardDelete(bno);		
	}
	
	
	
}

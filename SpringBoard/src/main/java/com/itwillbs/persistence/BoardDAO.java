package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

/**
 *   서비스 - Mybatis(mapper) 연결하는 객체	
 *   
 *   사용되는 쿼리구문을 호출
 */

public interface BoardDAO {
	
	// 글쓰기
	public void boardCreate(BoardVO vo) throws Exception;
	
	// 글 목록 조회
	public List<BoardVO> boardListSelect() throws Exception;
	
	// 글 내용 조회
	public BoardVO boardSelect(Integer bno) throws Exception;
	
	// 글 조회수 1증가
	public void boardViewcntUpdate(int bno) throws Exception;
	
	// 글 내용 수정
	public void boardUpdate(BoardVO vo) throws Exception;
	
	// 글 내용 삭제
	public void boardDelete(int bno) throws Exception;
	
	// 글 목록 조회(페이징)
	public List<BoardVO> boardListPageSelect(int page) throws Exception;

	// 글 목록 조회(페이징-Cri)
	public List<BoardVO> boardListCriSelect(Criteria cri) throws Exception;
	
	// 총 글의 개수 계산
	public int boardListCount() throws Exception;
	

}

package com.itwillbs.persistence;

import com.itwillbs.domain.BoardVO;

/**
 *   서비스 - Mybatis(mapper) 연결하는 객체	
 *   
 *   사용되는 쿼리구문을 호출
 */

public interface BoardDAO {
	
	// 글쓰기
	public void boardCreate(BoardVO vo) throws Exception;
	
	
	

}

package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	// mapper 접근가능한 객체 (SQL실행객체) 주입
	@Inject
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	private static final String NAMESPACE = "com.itwillbs.mapper.BoardMapper";
	
	@Override
	public void boardCreate(BoardVO vo) throws Exception {
		logger.debug(" boardCreate(BoardVO vo) -> mapper 호출 ");
		
		sqlSession.insert(NAMESPACE + ".createBoard", vo);
		
		logger.debug(" mapper 실행완료 -> 서비스 이동");
	}

	
	@Override
	public List<BoardVO> boardListSelect() throws Exception {
		logger.debug(" boardListSelect() 호출 ");
				
		return sqlSession.selectList(NAMESPACE + ".selectBoardList");
	}


	@Override
	public BoardVO boardSelect(Integer bno) throws Exception {
		logger.debug(" boardSelect(Integer bno) 호출 ");
		
		return sqlSession.selectOne(NAMESPACE + ".selectBoard",bno);
	}


	@Override
	public void boardViewcntUpdate(int bno) throws Exception {
		logger.debug(" boardViewcntUpdate(int bno) 호출 ");
		
		sqlSession.update(NAMESPACE + ".updateViewcnt", bno);
	}


	@Override
	public void boardUpdate(BoardVO vo) throws Exception {
		logger.debug(" boardUpdate(BoardVO vo) 호출 ");
			
		sqlSession.update(NAMESPACE +".updateBoard",vo);
	}
	
	
	
	
	
	
	

}

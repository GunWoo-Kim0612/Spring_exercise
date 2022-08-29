package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis {

	//sqlSessionTemplate을 사용해 DB처리할것임
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	
	//C
	public void insertBoard(BoardVO vo) {
		System.out.println("========>Spring mybaties로 insertBoard() 기능 처리");
		mybatis.insert("BoardDAO.insertBoard",vo);
	}
	
	
	
	//U
	public void updateBoard(BoardVO vo) {
		System.out.println("========>Spring mybaties로 updateBoard() 기능 처리");
		mybatis.update("BoardDAO.updateBoard",vo);

	}
	
	
		
	
	
	//D
	public void deleteBoard(BoardVO vo) {
		System.out.println("========>Spring mybaties로 deleteBoard() 기능 처리");
		mybatis.delete("BoardDAO.deleteBoard",vo);

	}
	
	
	
	
	//R ALL
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("========>Spring mybaties로 getBoardList() 기능 처리");
		
		return 	mybatis.selectList("BoardDAO.getBoardList",vo);

	}
	
	
	
	
	
	
	//R  1 row
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("========>Spring mybaties로 getBoard() 기능 처리");
		return 	mybatis.selectOne("BoardDAO.getBoard",vo);
	}
	
	
	
	

	//U readCount ++
	public void increaseCNT(BoardVO Bvo) {
		System.out.println("========>Spring   increaseCNT() 기능처리 ");

	}
}

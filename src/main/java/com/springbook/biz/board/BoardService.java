package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	
	//글등록
	public void insertBoard(BoardVO Bvo); 
	
	//글수정
	public void updateBoard(BoardVO Bvo);
	
	//글삭제
	public void deleteBoard(BoardVO Bvo); 
	
	//글 상세조회
	public BoardVO getBoard(BoardVO Bvo);
	
	
	//글 전체조회
	public List<BoardVO> getBoardList();
	


}

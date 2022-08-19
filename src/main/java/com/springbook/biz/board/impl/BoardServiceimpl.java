package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.LogAdvice;



@Service("BoardService")
public class BoardServiceimpl implements BoardService {

//	기존 JDBC방식
	//보통 생성자나 세터메소드를 이용한 값의 초기화를한다 이또한 의존 주입이지만  앞서했던  자동주입을 쓰겠다
//	@Autowired
//	private BoardDAO BoardDAO;
	
	//BoardDAO <-> BoardDAOSpring   왔다갔다 자유롭네
	
//	Spring JDBC방식
	@Autowired
	private BoardDAOSpring BoardDAO;
	
	
	
//	주석..처리, 각가메소드에 생성자부분도 주석처리
//	private LogAdvice log;
//	
//	public void BoardServiceImpl() {
//		log = new LogAdvice();
//	}

	
	@Override
	public void insertBoard(BoardVO Bvo) {
		
//		log.printLog();
		
		//exceoptionThrowing log 확인을 위한 강제 에러 발생
		//어노테이션을 통한 afterThrowing 도 확인했음...
		
//		if( Bvo.getSeq() == 0)
//			throw new IllegalArgumentException("0번글 등록 불가");
		
//		BoardDAO.insertBoard(Bvo);
		
		//for  transaction test  메소듣 두번실행 > 무결성 제약 오류 확인 		
		BoardDAO.insertBoard(Bvo);
	}

	@Override
	public void updateBoard(BoardVO Bvo) {
//		log.printLog();
		BoardDAO.updateBoard(Bvo);
	}

	@Override
	public void deleteBoard(BoardVO Bvo) {
//		log.printLog();
		BoardDAO.deleteBoard(Bvo);
	}

	@Override	
	public BoardVO getBoard(BoardVO Bvo) {
//		log.printLog();
		return BoardDAO.getBoard(Bvo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
//		log.printLog();
		return BoardDAO.getBoardList(vo);
	}

}


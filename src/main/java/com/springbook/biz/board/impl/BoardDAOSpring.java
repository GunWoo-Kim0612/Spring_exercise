package com.springbook.biz.board.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplat;
	
	
	//Transaction Test를 위해 주석처리
	private final String BOARD_INSERT = "INSERT INTO board2 (seq, title, writer, content)"
			+ " VALUES ((SELECT NVL(MAX(SEQ),0) + 1 FROM board2), ?, ?, ?)";
	
//	private final String BOARD_INSERT = "INSERT INTO board2 (seq, title, writer, content)"
//			+ " VALUES (?, ?, ?, ?)";
	
	private final String BOARD_UPDATE = "UPDATE board2 SET title=?, content=? WHERE seq=?";
	private final String BOARD_DELTE = "DELETE FROM board2 WHERE seq=?";
	private final String BOARD_GET = "SELECT *FROM board2 WHERE seq=?";
	private final String BOARD_LIST = "SELECT * FROM board2 ORDER BY seq DESC";
	private final String BOARD_CNT = "UPDATE board2 SET cnt = cnt+1 WHERE seq = ?";
	
	
	//C
	public void insertBoard(BoardVO Bvo) {
		System.out.println("========>Spring JDBC로 insertBoard() 기능 처리");
		
		jdbcTemplat.update(BOARD_INSERT,  Bvo.getTitle(), Bvo.getWriter(), Bvo.getContent());
//		jdbcTemplat.update(BOARD_INSERT,  Bvo.getSeq(), Bvo.getTitle(), Bvo.getWriter(), Bvo.getContent());
	}
	
	
	
	
	
	
	
	//U
	public void updateBoard(BoardVO Bvo) {
		System.out.println("========>Spring JDBC로 updateBoard() 기능 처리");
		
		jdbcTemplat.update(BOARD_UPDATE,  Bvo.getTitle(), Bvo.getContent(), Bvo.getSeq());
	}
	
	
	
	
	
	
	
	
	
	
	
	//D
	public void deleteBoard(BoardVO Bvo) {
		System.out.println("========>Spring JDBC로 deleteBoard() 기능 처리");
		
		jdbcTemplat.update(BOARD_DELTE,  Bvo.getSeq());
	}
	
	
	
	
	
	
	
	
	
	
	//R ALL
	public List<BoardVO> getBoardList() {
		System.out.println("========>Spring JDBC로 getBoardList() 기능 처리");
		
	

		
		return jdbcTemplat.query(BOARD_LIST, new BoardRowMapper());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//R  1 row
	public BoardVO getBoard(BoardVO Bvo) {
		System.out.println("========>Spring JDBC로 getBoard() 기능 처리");
		
		increaseCNT(Bvo);

//		반환이 배열임
		Object[] args = {Bvo.getSeq()};
		return jdbcTemplat.queryForObject(BOARD_GET, args, new BoardRowMapper());
		
//		rs객체를 RowMapper라는 객체 형식으로 지정해줌...미리선언하고  RowMapper 클래스 만들어줄것임
	}
	
	
	
	
	
	
	
	
	

	//U readCount ++
	public void increaseCNT(BoardVO Bvo) {
		System.out.println("===>JDBC increaseCNT() 기능처리 ");

		jdbcTemplat.update(BOARD_CNT,  Bvo.getSeq());
	}
}

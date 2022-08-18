package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;


@Repository("BoardDAO")
public class BoardDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	//상수형태
	private final String BOARD_INSERT = "INSERT INTO board2 (seq, title, writer, content)"
			+ " VALUES ((SELECT NVL(MAX(SEQ),0) + 1 FROM board2), ?, ?, ?)";
	private final String BOARD_UPDATE = "UPDATE board2 SET title=?, content=? WHERE seq=?";
	private final String BOARD_DELTE = "DELETE FROM board2 WHERE seq=?";
	private final String BOARD_GET = "SELECT *FROM board2 WHERE seq=?";
	private final String BOARD_LIST = "SELECT * FROM board2 ORDER BY seq DESC";
	private final String BOARD_CNT = "UPDATE board2 SET cnt = cnt+1 WHERE seq = ?";
	private final String BOARD_SEARCH = "SELECT * FROM board2 WHERE title=?";
	
	public void searchTitle(BoardVO Bvo) {
		System.out.println("===> JDBC searchTitle() 기능처리");
		
	}
	
	
	
	
	
	
	//추가
	public void insertBoard(BoardVO Bvo) {
		System.out.println("===>JDBC insertBoard() 기능처리 ");
		
		try {
			conn = JDBCUtil.getConnetion();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, Bvo.getTitle());
			stmt.setString(2, Bvo.getWriter());
			stmt.setString(3, Bvo.getContent());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt);
		}
	}
	
	
	
	
	
	
	
	
	
	//수정
	public void updateBoard(BoardVO Bvo) {
		
		System.out.println("===>JDBC updateBoard() 기능처리 ");
		
		
		increaseCNT(Bvo);

		try {
			conn = JDBCUtil.getConnetion();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, Bvo.getTitle());
			stmt.setString(2, Bvo.getContent());
			stmt.setInt(3, Bvo.getSeq());
			System.out.println("업데이트할 seq : " + Bvo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt);
		}
		
	}
	
	
	
	
	
	
	
	
	
	//삭제
	public void deleteBoard(BoardVO Bvo) {
		System.out.println("===>JDBC deleteBoard() 기능처리 ");

		
		
		try {
			conn = JDBCUtil.getConnetion();
			stmt = conn.prepareStatement(BOARD_DELTE);
			stmt.setInt(1, Bvo.getSeq());
			System.out.println("삭제할 seq " + Bvo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//레코드 1행 조회 용도
	public BoardVO getBoard(BoardVO Bvo) {
		System.out.println("===>JDBC getBoard() 기능처리 ");
		
		BoardVO Bvo1 = new BoardVO();
		
		//조회수 증가
		increaseCNT(Bvo);
		
		
		try {
			conn = JDBCUtil.getConnetion();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, Bvo.getSeq());

			System.out.println("업데이트할 seq : " + Bvo.getSeq());
			rs = stmt.executeQuery();

			
			if(rs.next()) {
				Bvo1.setSeq(rs.getInt("seq"));
				Bvo1.setTitle(rs.getString("title"));
				Bvo1.setContent(rs.getString("content"));
				Bvo1.setWriter(rs.getString("writer"));
				Bvo1.setRegDate(rs.getDate("regdate"));
				Bvo1.setCnt(rs.getInt("cnt"));
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn,stmt, rs);
		}
		return Bvo1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//전체조회
	public List<BoardVO> getBoardList() {
		
		System.out.println("===>JDBC getBoardList() 기능처리 ");
		
		List<BoardVO> boardList = new ArrayList();
		
		
		try {
			conn = JDBCUtil.getConnetion();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				BoardVO Bvo = new BoardVO();
				
				Bvo.setSeq(rs.getInt("seq"));
				Bvo.setTitle(rs.getString("title"));
				Bvo.setContent(rs.getString("content"));
				Bvo.setWriter(rs.getString("writer"));
				Bvo.setRegDate(rs.getDate("regdate"));
				Bvo.setCnt(rs.getInt("cnt"));
				
				boardList.add(Bvo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn,stmt, rs);
		}
		return boardList;
	}
	
	
	//조회수 증가
	public void increaseCNT(BoardVO Bvo) {
		System.out.println("===>JDBC increaseCNT() 기능처리 ");
		
		try {
			conn = JDBCUtil.getConnetion();
			stmt = conn.prepareStatement(BOARD_CNT);
			stmt.setInt(1, Bvo.getSeq());
			System.out.println("조회수 증가 seq : " + Bvo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt);
		}
	}

}

package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springbook.biz.board.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		BoardVO  Bvo = new BoardVO();
		
		Bvo.setSeq(rs.getInt("seq"));
		Bvo.setTitle(rs.getString("title"));
		Bvo.setContent(rs.getString("content"));
		Bvo.setWriter(rs.getString("writer"));
		Bvo.setRegDate(rs.getDate("regdate"));
		Bvo.setCnt(rs.getInt("cnt"));
		
		return Bvo;
	}
	
	
}

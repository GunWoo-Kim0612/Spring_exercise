package com.springbook.biz.loginservice.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.loginservice.user.UserVO;



@Repository
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String USER_GET = "SELECT * FROM users WHERE id = ? AND password = ? ";
	private final String USER_INSERT = "INSERT INTO USERS (ID, PASSWORD, NAME, ROLE) VALUES (?, ?,?,?)";
	private final String USER_UPDATE= "UPDATEINTO USERS SET id = ?, password = ?, name = ?, role = ?";
	
	
	//id password 로 회원 조회
	public UserVO getUser(UserVO Uvo) {
		UserVO user = null;
		
		System.out.println("==>JDBC getUser() 기능처리");
		
		
		try {
			conn = JDBCUtil.getConnetion();
			stmt= conn.prepareStatement(USER_GET);
			stmt.setString(1, Uvo.getId());
			stmt.setString(2, Uvo.getPassword());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt, rs);
			
		}		
		return user;
	}
	
	
	
	
	
	
	
	
	
	//insert User
	public void insertUser(UserVO Uvo) {
		
		System.out.println("==>JDBC insertUser() 기능처리");
		
		
		try {
			conn = JDBCUtil.getConnetion();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, Uvo.getId());
			stmt.setString(2, Uvo.getPassword());
			stmt.setString(3, Uvo.getName());
			stmt.setString(4, Uvo.getRole());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt);
		}
	}
	
	
	
	
	
	
	public void updateUser(UserVO Uvo) {
		
		System.out.println("==>JDBC updateUser() 기능처리");
		
		
		try {
			conn = JDBCUtil.getConnetion();
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, Uvo.getId());
			stmt.setString(2, Uvo.getName());
			stmt.setString(3, Uvo.getPassword());
			stmt.setString(4, Uvo.getRole());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt);
		}
	}
}

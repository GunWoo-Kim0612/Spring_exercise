package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	public static Connection getConnetion() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			System.out.println("DB연결완료");
			
			//생성된 Connection 객체만 리턴해주는 형태로
			return conn;
			
		}catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이브 로드 에러");
		}catch (SQLException e) {
			System.out.println("DB연결오류");
		}
		
		return null;
	}
	
	
	public static void close(Connection conn,PreparedStatement stmt,ResultSet rs) {
		
		
		try{
			if(!stmt.isClosed())
				stmt.close();
		}
			catch (Exception e) {
				e.printStackTrace();
		}finally {
			stmt = null;
		}
			
		
		
		try{
			if(!conn.isClosed())
				conn.close();
		}
			catch (Exception e) {
				e.printStackTrace();
		}finally {
			conn = null;
		}
			
		
		try{
			if(!rs.isClosed())
				rs.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			rs = null;
		}
		
			
			
			
	}
	
	public static void close(Connection conn,PreparedStatement stmt) {
		try{
			if(!stmt.isClosed())
				stmt.close();
		}
			catch (Exception e) {
				e.printStackTrace();
		}finally {
			stmt = null;
		}
			
		try{
			if(!conn.isClosed())
				conn.close();
		}
			catch (Exception e) {
				e.printStackTrace();
		}finally {
			conn = null;
		}
			
	}
	
	
}

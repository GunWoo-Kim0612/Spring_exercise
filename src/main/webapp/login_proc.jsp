<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.springbook.biz.loginservice.user.impl.UserDAO" %>
<%@ page import="com.springbook.biz.loginservice.user.UserVO" %>
    
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");

	UserVO Uvo = new UserVO();
	Uvo.setId(id);
	Uvo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	
	//결과를 UserVO타입으로 반환	id password로 DB조회
	UserVO user = userDAO.getUser(Uvo);			
	
	
	if(user != null){
		response.sendRedirect("getBoardList.jsp");
	}else{
		response.sendRedirect("login.jsp");
	}
%>
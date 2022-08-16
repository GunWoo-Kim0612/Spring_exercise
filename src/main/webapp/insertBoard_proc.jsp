<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="oracle.net.aso.b"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.springbook.biz.loginservice.user.impl.UserDAO" %>
<%@ page import="com.springbook.biz.loginservice.user.UserVO" %>
    
<%
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	BoardVO Bvo = new BoardVO();
	Bvo.setTitle(title);
	Bvo.setWriter(writer);
	Bvo.setContent(content);
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.insertBoard(Bvo);
	
	response.sendRedirect("getBoardList.jsp");
%>
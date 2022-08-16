<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.loginservice.user.impl.UserDAO" %>
<%@ page import="com.springbook.biz.loginservice.user.UserVO" %>
  
  
<%
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String seq = request.getParameter("seq");
	
	
	
	BoardVO Bvo = new BoardVO();
	Bvo.setTitle(title);
	Bvo.setContent(content);
	Bvo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.updateBoard(Bvo);
	
	response.sendRedirect("getBoardList.jsp");
%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.springbook.biz.loginservice.user.impl.UserDAO" %>
<%@ page import="com.springbook.biz.loginservice.user.UserVO" %>
    
<%
	String seq = request.getParameter("seq");
	
	BoardVO Bvo = new BoardVO();
	Bvo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.deleteBoard(Bvo);
	
	response.sendRedirect("getBoardList.jsp");
%>
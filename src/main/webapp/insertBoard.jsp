<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@ page import="com.springbook.biz.board.BoardVO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>글 등록</h1>
		<a href="logout_proc.jsp">log-out</a>
		<hr>
		<form action="insertBoard.do" method="post">
			<table>
				<tr>
					<td bgcolor="orange">제목</td>
					<td align="left">
						<input name="title" type="text" >
					</td>
					
				</tr>
				<tr>
					<td bgcolor="orange" >작성자</td>
					<td align="left">
						<input name="writer" type="text" ">
					</td>
					
				</tr>
				<tr>
					<td bgcolor="orange" >내용</td>
					<td align="left">
						<textarea cols="40" rows="10" name="content" type="text"></textarea>
					</td>
					
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="새글등록"></td>
				</tr>
			</table>
			<hr>
			<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;		
			<a href="deleteBoard.jsp">글삭제</a>&nbsp;&nbsp;&nbsp;		
			<a href="getBoardList.jsp">글목록</a>&nbsp;&nbsp;&nbsp;		
		</form>
	</center>
</body>
</html>
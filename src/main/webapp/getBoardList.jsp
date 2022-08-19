<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="javax.websocket.Session"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@ page import="com.springbook.biz.board.BoardVO" %>

<!-- jstl coretag 사용하겠음 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
/*  	BoardVO Bvo = new BoardVO();
	BoardDAO boardDAO = new BoardDAO(); */
	//List<BoardVO> boardList = (List)session.getAttribute("boardList");
	
	
	//이제는 세션에서 가져오는게 아니고 ModelAndView이 request에 저장했으니 request에서 가져오는데
	// jstl 을 사용해서 가져오겠다
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <center>
      <h1>글 목록</h1>
      <h3>
      <!-- sesstion.getattri~~ 로받아올수있지만 el로 간략하게 속성이름을 영역객체에서 찾아 사용 -->
         ${userName } 환영합니다.<a href="logout.do">Log-out</a>
      </h3>
      <!--검색시 해당 글만 불러와야함 .jsp ==> .do변경 , post에 해당하는 컨트롤 새로 메소드만들어주?	-->
      <form action="getBoardList.do" method="post">
         <table border="1" cellpadding="0" cellspacing="0" width="700">
            <tr>
               <td align="right">
                  <select name="searchCondition">
                  
                  	<!-- @ModelAttribute로 만들어준 map정보 가져오는 방식으로 수정-->
                     <!-- <option value="TITLE">제목
                     <option value="CONTENT">내용 -->
                     <c:forEach items="${conditionMap }" var="option">
                     	<option value="${option.value }"> ${option.key }
                     	<!-- 보이는 값은 key값 -->
                     </c:forEach>
                     
                  </select>
                  <input name="searchKeyword" type="text" />
                  <input type="submit" value="검색">
               </td>
            </tr>
         </table>
      </form>
      
      <table border="1" cellpadding="0" cellspacing="0" width="700">
         <tr>
            <th bgcolor="orange" width="100">번호</th>
            <th bgcolor="orange" width="200">제목</th>
            <th bgcolor="orange" width="150">작성자</th>
            <th bgcolor="orange" width="150">등록일</th>
            <th bgcolor="orange" width="100">조회수</th>
         </tr>
         
         
         <!-- 세션에서 받아온 정보 돌리는 코드였음 -->
        <%--  <%
            for(BoardVO board : boardList){
         %> --%>
         
         <!-- el식 {}  영역객체에서 순서대로 값을 찾아 가져오는... request에서 가져옴 -->
         <c:forEach items="${boardList}" var="board">
         
																						         <%-- <tr>
																						            <td><%=board.getSeq()%></td>
																						            <td><a href="getBoard.do?seq=<%=board.getSeq()%>"><%=board.getTitle()%></a></td>
																						            <td><%=board.getWriter()%></td>
																						            <td><%=board.getRegDate()%></td>
																						            <td><%=board.getCnt()%></td>
																						         </tr> --%>
	         <tr>
	            <td>${board.seq }</td>
	            <td><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
	            <td>${board.writer }</td>
	            <td>${board.regDate }</td>
	            <td>${board.cnt }</td>
	         </tr>
         
         </c:forEach>

         
		<!--세션 스크립트릿이였음 -->         
         <%-- <%} %> --%>
      </table>
      <a href="insertBoard.jsp">새글 등록</a>
   </center>
</body>
</html>
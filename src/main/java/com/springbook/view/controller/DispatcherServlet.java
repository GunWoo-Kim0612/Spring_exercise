package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.loginservice.user.UserVO;
import com.springbook.biz.loginservice.user.impl.UserDAO;


//프론트 컨트롤러

@WebServlet("*.do") // <-- Mapping 정보 수정되어있음
public class DispatcherServlet extends HttpServlet {
 
 // 모든정보를 DispatcherServlet으로 처리 ==>> url 뒤에 .do
 // ex) http://localhost:9999/BoardWeb01/getBoardList.do
 
 private static final long serialVersionUID = 1L;
  
  public DispatcherServlet() {
      super();
  }

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    process(request, response);

 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    process(request, response);
 
 }
 
 //
 private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
    
    //현재 주소값 불러오는 메소드
    String uri = request.getRequestURI();   //   http://localhost:9999/BoardWeb01/getBoardList.do
    
    String path = uri.substring(uri.lastIndexOf("/"));   //   /getBoardList.do
    
    //현재값 확인용
    System.out.println(path);
 
    
//LOGIN    
    if(path.equals("/login.do")) {
       
       System.out.println("Login");
       
       //login_proc.jsp 내용임!
       
       String id = request.getParameter("id");
       String password = request.getParameter("password");
       
       UserVO vo = new UserVO();
       
       vo.setId(id);
       vo.setPassword(password);
       
       UserDAO userDAO = new UserDAO();
       
       UserVO user = userDAO.getUser(vo);
       
       if(user != null){
          
          response.sendRedirect("getBoardList.do");
          
       }else{
          
          response.sendRedirect("login.jsp");
          
       }
       
       
       
//LOGOUT       
    }else if(path.equals("/logout.do")) {
       
       System.out.println("Logout");
       System.out.println("세션 만료");
       
       HttpSession session = request.getSession();
       session.setMaxInactiveInterval(0);
       
       
       response.sendRedirect("login.do");

       
//INSERT      
    }else if(path.equals("/insertBoard.do")) {
       
       System.out.println("insertBoard");
       
       request.setCharacterEncoding("UTF-8");
       String title = request.getParameter("title");
       String writer = request.getParameter("writer");
       String content = request.getParameter("content");
       
       BoardVO vo = new BoardVO();
       
       vo.setTitle(title);
       vo.setWriter(writer);
       vo.setContent(content);
       BoardDAO boardDAO = new BoardDAO();
       boardDAO.insertBoard(vo);
       
       response.sendRedirect("getBoardList.do");
       
       
       
//DELETE       
    }else if(path.equals("/deleteBoard.do")) {
        
        System.out.println("deleteBoard");
        
        String seq = request.getParameter("seq");
    	
    	BoardVO Bvo = new BoardVO();
    	Bvo.setSeq(Integer.parseInt(seq));
    	
    	BoardDAO boardDAO = new BoardDAO();
    	boardDAO.deleteBoard(Bvo);
    	
    	response.sendRedirect("getBoardList.do");
        
        
//UPDATE        
    }else if(path.equals("/updateBoard.do")) {
        
        
    	System.out.println("updateBoard");
    	
    	
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
    	
    	response.sendRedirect("getBoardList.do");
    	
    	
    	
    }else if(path.equals("/getBoard.do")) {
       
       System.out.println("getBoard");
       
       String seq = request.getParameter("seq");
       
       BoardVO vo = new BoardVO();
       
       vo.setSeq(Integer.parseInt(seq));
       
       BoardDAO boardDAO = new BoardDAO();
       BoardVO board = boardDAO.getBoard(vo);
       
       HttpSession session = request.getSession();
       session.setAttribute("board", board);
       
       response.sendRedirect("getBoard.jsp");

  
//GETLIST       
    }else if(path.equals("/getBoardList.do")) {
       
       System.out.println("getBoardList");
       
       BoardDAO boardDAO = new BoardDAO();
       
       List<BoardVO> boardList = boardDAO.getBoardList();
       System.out.println(boardList);
       // boardList를 리퀘스트 영역에 저장!
       //이번엔 그냥 강사님이 세션영역에 세팅하심
       HttpSession session = request.getSession();
       session.setAttribute("boardList", boardList);
       
       //값을 보내줘야 리스트 출력이 되기 때문에 포워드방식으로 페이지 이동해야함 
       //RequestDispatcher rs = request.getRequestDispatcher("getBoardList.jsp");
       response.sendRedirect("getBoardList.jsp");
       
       
    }
    
 }

}
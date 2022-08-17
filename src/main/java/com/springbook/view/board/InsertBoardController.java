package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Controller 어노테이션
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//내장 Controller
//import org.springframework.web.servlet.mvc.Controller;
//데이터 및 url 정보를 넘겨주는 ModelAndView 객체  Controller 오버라이딩메소드의 타입
//import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//직접 만들어본 Controller
//import com.springbook.view.controller.Controller;

//public class InsertBoardController implements Controller{

@Controller
public class InsertBoardController{
	
	@RequestMapping("/insertBoard.do")
	public void insertBoard(HttpServletRequest request) {
		System.out.println("글 추가");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		System.out.println(title);
		System.out.println(content);
		System.out.println(writer);
		
		
		
		BoardVO vo = new BoardVO();
		
		BoardDAO boardDAO = new BoardDAO();
		
		vo.setContent(content);
		vo.setTitle(title);
		vo.setWriter(writer);
		
		
		boardDAO.insertBoard(vo);
	}
	
	
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("글 추가");
//		
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String writer = request.getParameter("writer");
//		
//		System.out.println(title);
//		System.out.println(content);
//		System.out.println(writer);
//		
//		
//		
//		BoardVO vo = new BoardVO();
//		
//		BoardDAO boardDAO = new BoardDAO();
//		
//		vo.setContent(content);
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		
//		
//		boardDAO.insertBoard(vo);
//		
//		ModelAndView mav = new ModelAndView();
//
//		mav.setViewName("redirect:getBoardList.do");
//		
//		return mav;
//		
//		
//		return "getBoardList.do";
//	}
}

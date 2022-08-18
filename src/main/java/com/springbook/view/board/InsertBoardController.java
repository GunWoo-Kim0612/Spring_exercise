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
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("insert 컨트롤러");

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
	
		//메소드에 vo 객체를 매개함으로써... 해당 동작들이 Command객체로 인해 자동 Set됨   
		//코드만 봐서는 어떤값을 insert하는지 알수없다   command객체 개념을 제대로 숙지해야함
		
		//외부에서 getPara  값을 받아  set하는 과정이 일괄적으로 처리됨  파라미터명은  vo객체에 Setter메소드를 통하므로  파라미터와  객체의 변수 이름이 일치해야 한다
		
		boardDAO.insertBoard(vo);
		
		return "redirect:getBoardList.do"; 		//이동하는 방식은 포워드방식
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

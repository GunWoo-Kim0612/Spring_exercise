package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
//import com.springbook.view.controller.Controller;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("글목록처리");
		BoardVO Bvo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList();
		
		
		//직접만든 Controller에서는 세션으로 정보 넘겨줬었음
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
		
		
		
		//내장 Controller는 ModelAndView 방식
		ModelAndView mav = new ModelAndView();
		
		//객체넘져눔  세션과 형식은 동일   속성이름 , 객체정보
		mav.addObject("boardList", boardList);			//여기서 저장한 정보는 request객체에 저장됨
		
		//실제 실행할 페이지 이름직접써주고
		mav.setViewName("getBoardList");
		
		return mav;
	}
	
}

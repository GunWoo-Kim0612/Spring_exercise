package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
//import com.springbook.view.controller.Controller;

public class GetBaordController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("글 상세조회");
		
		//시퀀스정보는 getBoardList.do에서 파라미터를 담아 전송했음     href="getBoard.do?seq~~"
		String seq = request.getParameter("seq");		
		System.out.println("seq:" + seq);
		
		BoardVO Bvo = new BoardVO();
		Bvo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO =  new BoardDAO();
		BoardVO board = boardDAO.getBoard(Bvo);
		
		/*
		 * HttpSession session = request.getSession(); session.setAttribute("getBoard",
		 * board);
		 */
		
//		return "getBoard";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board",board);
		
		mav.setViewName("getBoard");
		
		return mav;
	}
	
}

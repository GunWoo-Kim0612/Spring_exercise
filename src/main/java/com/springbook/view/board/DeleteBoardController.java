package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.board.impl.BoardDAOSpring;
//import com.springbook.view.controller.Controller;

@Controller
public class DeleteBoardController {
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boadrDAO) {
		System.out.println("delete컨트롤러");
		
		boadrDAO.deleteBoard(vo);
		
		return "getBoardList.do";
	}
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		
//		
//		System.out.println("글삭제처리");
//		
//		String seq = request.getParameter("seq");		
//		System.out.println(seq);
//		BoardVO vo = new BoardVO();
//		
//		vo.setSeq(Integer.parseInt(seq));
//		
//		//BoardDAOSpring으로 하니까 안됨 외않됌
//		BoardDAO boardDAO = new BoardDAO();
//		
//		boardDAO.deleteBoard(vo);
//		
//		
////		return "getBoardList.do";
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		
//		return mav;
//	}
}

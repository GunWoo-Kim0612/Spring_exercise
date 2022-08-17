package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
//import com.springbook.view.controller.Controller;

public class UpdateBoardController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		BoardVO vo = new BoardVO();
		
		BoardDAO boarDAO = new BoardDAO();
		
		String seq = request.getParameter("seq");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		
		vo.setContent(content);
		vo.setTitle(title);
		vo.setSeq(Integer.parseInt(seq));
		
		boarDAO.updateBoard(vo);
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
		
//		return "getBoardList.do";
	}
}

package com.springbook.view.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;


@Controller
public class BoardController {
	
	
	
	@RequestMapping("getBoardList.do")		//요청정보 맵핑
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		mav.addObject("boardList", boardDAO.getBoardList());
		mav.setViewName("getBoardList.jsp");
		 
		return mav;
	}
	
	
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		
		System.out.println("컨트롤러 vo확인 seq"+vo.getSeq())	;
		System.out.println("컨트롤러 vo확인 content"+vo.getContent());

		
		
		return mav;
	}

	
	@RequestMapping("/updateBoard.do")
	public String UpdateBoardController(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("update 컨트롤러");

		
		System.out.println("updateBoard.do처리");
		
		boardDAO.updateBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("insert 컨트롤러");


		boardDAO.insertBoard(vo);
		
		return "redirect:getBoardList.do"; 		//이동하는 방식은 포워드방식
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boadrDAO) {
		System.out.println("delete컨트롤러");
		
		boadrDAO.deleteBoard(vo);
		
		return "getBoardList.do";
	}
	
			
	
	
	


}

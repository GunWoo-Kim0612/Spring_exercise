package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
		
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boadrDAO) {
		System.out.println("delete컨트롤러");
		
		boadrDAO.deleteBoard(vo);
		
		return "getBoardList.do";
	}
	
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		//타입 String으로, 모델앤뷰중 모델방식만 사용하도록   
		
		
//		model.addObject("board", boardDAO.getBoard(vo));
//		mav.setViewName("getBoard.jsp");

		BoardVO Data = boardDAO.getBoard(vo);
		model.addAttribute("board", boardDAO.getBoard(vo));
		System.out.println("컨트롤러 vo seq 확인  : "+vo.getSeq())	;
		System.out.println("컨트롤러 vo content 확인  : "+Data.getContent());
		
		return "getBoard.jsp";
	}
	
	
	
	
	@RequestMapping("getBoardList.do")		//요청정보 맵핑
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		mav.addObject("boardList", boardDAO.getBoardList());
		mav.setViewName("getBoardList.jsp");
		 
		return mav;
	}
	

	//검색어관련 기능 추가할수있도록  vo만들거임 

	
	

//	//@RequestParam을 통해 검색기능을 구현하는 메소드로 변경...  get, post방식으로 구분해  메소드 두개 써도됨	
////	value : 받아올key워드값[title, content (getBoardList.jsp <select>참고], 대상 : title, requried : 필수는아니다??
//	@RequestMapping("getBoardList.do")		//요청정보 맵핑
//	public ModelAndView getBoardList(
//			@RequestParam(value="searchCondition", defaultValue = "title",required = false)String condition,
//			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
//			BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		
//		System.out.println("글 목록 검색 처리");
//		System.out.println("검색조건 : " + condition);
//		System.out.println("검색단어 : " + keyword);
//		
//		mav.addObject("boardList", boardDAO.getBoardList());
//		mav.setViewName("getBoardList.jsp");
//		 
//		return mav;
//	}
//	
	
	
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("insert 컨트롤러");

		boardDAO.insertBoard(vo);
		
		return "redirect:getBoardList.do"; 		//이동하는 방식은 포워드방식
	}
	
	
	
	@RequestMapping("/updateBoard.do")
	public String UpdateBoardController(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("update 컨트롤러");

		
		System.out.println("updateBoard.do처리");
		
		boardDAO.updateBoard(vo);
		return "redirect:getBoardList.do";
	}
}

package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")		
public class BoardController {
		
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boadrDAO) {
		System.out.println("delete컨트롤러");
		
//		boadrDAO.deleteBoard(vo);
		boardService.deleteBoard(vo);
		
		return "getBoardList.do";
	}
	
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		//타입 String으로, 모델앤뷰중 모델방식만 사용하도록   
		
		
//		model.addObject("board", boardDAO.getBoard(vo));
//		mav.setViewName("getBoard.jsp");

		BoardVO Data = boardDAO.getBoard(vo);
//		model.addAttribute("board", boardDAO.getBoard(vo));
		model.addAttribute("board", boardService.getBoard(vo));
		System.out.println("컨트롤러 vo seq 확인  : "+vo.getSeq())	;
		System.out.println("컨트롤러 vo content 확인  : "+Data.getContent());
		
		return "getBoard.jsp";
	}
	
	
	
	
	
	
	
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		
		
		//헷갈릴 수 있으니 jsp searchCondition의 option value 대문자로 변경  
		//여기 속성명도 대문자로..
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		System.out.println("Map메소드 실행 : ");
		System.out.println("map.values()  : " + conditionMap.values());
		
		return conditionMap;
	}
	
	
	
	
	
	@RequestMapping("getBoardList.do")		//요청정보 맵핑
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		String으로수정
		
//		mav.addObject("boardList", boardDAO.getBoardList());
		mav.addObject("boardList", boardService.getBoardList());
		mav.setViewName("getBoardList.jsp");
//		System.out.println("mav.getModelMap() : " + mav.getModelMap());
//		System.out.println("mav.getModel() : " + mav.getModel());
//		System.out.println("투스트링"+mav.toString());
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

//		boardDAO.insertBoard(vo);      BoardDAO---> BoardDAOSpring으로변경
		boardService.insertBoard(vo);
		
		return "redirect:getBoardList.do"; 		//기본 이동하는 방식은 포워드방식 but redirect로 바꿔줬음
	}
	
	
	
	@RequestMapping("/updateBoard.do")
	public String UpdateBoardController(@ModelAttribute("board")BoardVO vo, BoardDAO boardDAO) {
		System.out.println("update 컨트롤러");
		
		System.out.println("updateBoard.do처리");
		
		//로그인하지않았을경우 작성자데이터는 null값이 들어가는 구조 
		//수정하지않은 값이라도 해당게시글의 
		//null값이 뜨던 vo객체의 정보들이   세션영역으로부터 setter주입되었다  -> 확인
		System.out.println("세션으로부터 주입받은 seq :"+vo.getSeq());
		System.out.println("세션으로부터 주입받은 title :"+vo.getTitle());
		System.out.println("세션으로부터 주입받은 content :"+vo.getContent());
		System.out.println("세션으로부터 주입받은 Writer :"+vo.getWriter());
		System.out.println("세션으로부터 주입받은 RegDate :"+vo.getRegDate());
		System.out.println("세션으로부터 주입받은 Cnt :"+vo.getCnt());
		
//		boardDAO.updateBoard(vo);
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}
}

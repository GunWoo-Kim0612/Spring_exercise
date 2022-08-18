package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.impl.BoardDAO;

//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.loginservice.user.UserVO;
import com.springbook.biz.loginservice.user.impl.UserDAO;


@Controller
public class LoginController {

	@RequestMapping("/login.do")
	public String Login(UserVO vo, UserDAO UserDAO ) {
		System.out.println("로그인 컨트롤러");
		
		UserDAO.getUser(vo);
		
		if(vo.getId()!= null) {
			return "redirect:getBoardList.do";
		} else {
			return "redirect:login.jsp";
		}
			
	}
	
	
	
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		
//		System.out.println("로그인처리 핸들러를통한 처리");
//		
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		
//		UserVO Uvo = new UserVO();
//		Uvo.setId(id);
//		Uvo.setPassword(password);
//		
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(Uvo);
//		
//		
//		//스프링 내장 컨트롤 사용이전
////		if(user!= null) {
////			return "getBoardList.do";
////		} else {
////			return "login";
////		}
//		
//		
//		//스프링 내장 컨트롤 사용시 반환타입
//		ModelAndView mav = new ModelAndView();
//		
//		if(user!= null) {
//			mav.setViewName("redirect:getBoardList.do");
//		} else {
//			mav.setViewName("redirect:login.jsp");    			//ViewResolver가 없어서   prefix, suffix가없으니 jsp붙여줘야함
//		}
//		
//		return mav;
//		
//	}

}

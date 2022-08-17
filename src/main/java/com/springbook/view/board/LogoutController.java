package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//import com.springbook.view.controller.Controller;

public class LogoutController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("logout기능 처리");
		
		
		HttpSession session = request.getSession();
		//세션 객체정보를 모두 없애주면됨
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:login.jsp");
		
		return mav;
//		return "login";
	}
}

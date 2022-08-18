package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

//import com.springbook.view.controller.Controller;
@Controller
public class LogoutController {
	
	@RequestMapping("/logout.do")
	public String Logout(HttpSession session) {
		
//		마찬가지로 httpsession 객체 또한 매개변수이므로  스프링컨테이너가 객체 자동생성해줌
		System.out.println("로그아웃컨트롤러");
		session.invalidate();
		return "login.jsp";
	}
//	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		
//		System.out.println("logout기능 처리");
//		
//		
//		HttpSession session = request.getSession();
//		//세션 객체정보를 모두 없애주면됨
//		session.invalidate();
//		
//		ModelAndView mav = new ModelAndView();
//		
//		mav.setViewName("redirect:login.jsp");
//		
//		return mav;
////		return "login";
//	}
}

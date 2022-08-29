package com.springbook.view.user;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.loginservice.user.UserVO;
import com.springbook.biz.loginservice.user.impl.UserDAO;


@Controller
public class LoginController {

	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String LoginView(@ModelAttribute("user")UserVO vo) {
		
		
		//@ModelAttribute("user") 영역객체에 저장하는 속성이름을 정해주는것 --> login.jsp userVo--> user
	

		//기능적으로  로그인화면에 자주사용하는 아이디 비밀번호등 제공하는 용도로 사용이가능
		//이렇게 하드코딩하는게 아니고 쿠키를 사용해야함   
		//구글 자동완성기능있어서 안해도 ㄱㅊ..  그냥 이런식으로 분리해 사용할수있다는것
		System.out.println("로그인 화면으로 이동...");
		
		
		//여기서Set메소드를 통해 영역객체에 저장된 값을 jsp 에서 userVO로 불러옴
//		vo.setId("TEST");
//		vo.setPassword("TEST1234");
		return "login.jsp";
		
	
	}
	
	//
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String Login(@ModelAttribute("user")UserVO vo, UserDAO UserDAO, HttpSession session ) {

		System.out.println("로그인 컨트롤러");
		
		UserVO user = UserDAO.getUser(vo);
		
		if(user!= null) {
			session.setAttribute("userName", user.getName());
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

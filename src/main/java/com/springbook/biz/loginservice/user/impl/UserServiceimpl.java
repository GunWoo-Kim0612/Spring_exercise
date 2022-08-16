package com.springbook.biz.loginservice.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.loginservice.user.UserService;
import com.springbook.biz.loginservice.user.UserVO;

import lombok.Setter;


//Setter  말그대로 setter메소드 생성해줌  우측 outline에 setUser가 생성되어있음을 확인
//@Setter
@Service("userService")
public class UserServiceimpl implements UserService{
	
	

//	세터 메서드 생성시 메서드에 추가할 어노테이션을 지정한다.  jdk7에선 _ 두개   
//	즉  UserDAO에서 생성하 메서드 각각이 자동주입된다 이말이야!
	@Setter(onMethod=@__({@Autowired}))
	private UserDAO userDAO;

	
	
	
	@Override
	public UserVO getUser(UserVO Uvo) {
		return userDAO.getUser(Uvo);
	}




	@Override
	public void insertUser(UserVO Uvo) {
		userDAO.insertUser(Uvo);
	}
	

}

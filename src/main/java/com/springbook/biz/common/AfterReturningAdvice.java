package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.loginservice.user.UserVO;


@Service
@Aspect
public class AfterReturningAdvice {
	
	@Pointcut("execution(* com.springbook.biz..*impl.*(..))")
	public void getPointcut() {}
	
	@AfterReturning(pointcut = "getPointcut()", returning = "returnObj")
	
	public void afterLog(JoinPoint jp, Object returnObj) {
		System.out.println("======================AFTER RETURNING==============================");
//		System.out.println("[AFTER RETURNING] 비즈니스 로직 수행 후 동작 START  ");
		System.out.println("afterAllMethod " + jp.getSignature());
	    System.out.println("returnObj: " + returnObj);
		
		String method = jp.getSignature().getName();
		
		System.out.println("실행된 메소드 : " + method);
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
			
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "로그인(Admin)");
			}
		}
		
		
//		System.out.println("[사후처리] 비즈니스 로직 수행 후 동작 END ");
		System.out.println();
	}
}

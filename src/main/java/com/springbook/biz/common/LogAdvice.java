package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Aspect
//@Service
public class LogAdvice {
	
	//포인트컷 대상
//	@Pointcut("execution(* com.springbook.biz..*impl.*(..))")
//	public void allPointcut(){}
	
	//포인트컷의 동작시점
//	@Before("allPointcut()")
	
	
	public void printLog() {
		System.out.println("[공통로그] 비즈니스 로직 수행 전 동작");
	}
}

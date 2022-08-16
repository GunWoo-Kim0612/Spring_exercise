package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdive {
	
	
	@Pointcut("execution(* com.springbook.biz..*impl.*(..))")
	public void allPointcut() {}
	
	@After("allPointcut()")
	
	public void finallyLog() {
		System.out.println("======================AFTER========================================");
		System.out.println("[AFTER] 비즈니스 로직 수행 후 무조건 동작 : finally");
		
		System.out.println();
	}
}

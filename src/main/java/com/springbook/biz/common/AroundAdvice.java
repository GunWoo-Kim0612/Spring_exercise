package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


@Service
@Aspect
public class AroundAdvice {
	
	@Pointcut("execution(* com.springbook.biz..*impl.*(..))")
	public void allPointcut() {}
	
	

	@Around("allPointcut()")
	
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("======================AROUND BEFORE=================================");
		//advice before after 가 동시에 처리된다고 보면 된다
		
		//point cut 실행전
//		System.out.println("[AROUND_Before] : 비즈니스 메소드 수행 전에 처리할 내용..");
		String method = pjp.getSignature().getName();
		
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		Object returnObj = pjp.proceed();
		
		stopwatch.stop();
		
		//point cut 실행후
		System.out.println();
		System.out.println("======================AROUND AFTER=================================");

//		System.out.println("[AROUND_After] : 비즈니스 메소드 수행 후에 처리할 내용..");
		System.out.println(method+ "() 메소드 수행시간에 걸린 시간 : " + stopwatch.getTotalTimeMillis()+ "(ms)");
		System.out.println("returnObj : " + returnObj);
		
		System.out.println();
		return returnObj;
	}
}

package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class BeforeAdvice {
	
//	어노테이션 방식으로 수정
	//1 @Service 빈등록 
	//2 @Aspect 지정 
	//3 @Pointcut  포인트컷대상 설정
	
	
	@Pointcut("execution(* com.springbook.biz..*impl.*(..))")
	public void allPointcut() {}
	
	@Before("allPointcut()")
	
	
	public void beforeLog(JoinPoint jp) {
		
		System.out.println("======================BEFORE========================================");
//		System.out.println("[BEFORE ] 비즈니스 로직 수행 전 동작 START");
		
		String method = jp.getSignature().getName();
		
		Object[] jpArgs =  jp.getArgs();
		
		Object target = jp.getTarget();
		
		System.out.println("타겟 : " + target.toString());
		
		System.out.println("실행된 메소드 : "+ method);
		for(int i=0; i<jpArgs.length; i++) {
			System.out.println("전달한 매개변수 : "+ jpArgs[i].toString());
			
		}
		System.out.println("[BEFORE] 비즈니스 로직 수행 전 동작 END");

		System.out.println();
	}
}

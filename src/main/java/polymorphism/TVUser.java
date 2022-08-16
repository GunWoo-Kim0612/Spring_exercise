package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {

//		SamsungTV tv = new SamsungTV();
//		tv.powerOff();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		
//		LgTV lgTV = new LgTV();
//		
//		lgTV.powerOn();
//		lgTV.powerOff();
//		lgTV.volumeUp();
//		lgTV.volumeDown();
		
		
		//beanFactory를 통해 사용
//		BeanFactory factory = new BeanFactory();
//		
//		//TV타입으로 반환, object 캐스팅 
//		TV s_tv = (TV)factory.getBean("samsung");
//		TV l_tv = (TV)factory.getBean("lg");
//		
//
//		s_tv.powerOn();
//		l_tv.powerOn();
		//이런 구조가 결합도가 최소화된 구조이다 이상적임   스프링은 이런구조가 되어있다네요?
		
		
		
		//IOC
		//위의 작업(팩토리클래스-getBean -> samsung 객체생성...)을 xml파일을 가져다 쓰는거로 대체함  spring 내장기능 이게 의존주입? 
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		//xml의 id값을 가져다 사용, 반환타입 object 역시 캐스팅.
//		TV s_tv =  (TV)factory.getBean("samsung");
//		TV s_tv2 =  (TV)factory.getBean("samsung");
//		TV s_tv3 =  (TV)factory.getBean("samsung");
		//samsung Tv 를 applicationConetext.xml에서  scope="prototype"으로 설정시  객체생성마다 객체생성메시지가 실행됨 --> 
		//기본값 : 싱글톤 타입
		
		
//		TV l_tv =  (TV)factory.getBean("lg");
//		TV l_tv2 =  (TV)factory.getBean("lg");
//		TV l_tv3 =  (TV)factory.getBean("lg");
		
		
		
		//안좋다네여 ㅇㅇ 안좋아보임 
//		s_tv.powerOn();
//		s_tv.volumeUp();
//		s_tv.volumeDown();
//		l_tv.powerOn();
		
		
		
		//lgTV를 어노테이션으로 사용
		TV lg_tv = (TV)factory.getBean("lg");
		System.out.println("어노테이션을 활용한 빈객체 사용");
		lg_tv.powerOn();
		
		
		//의존 자동주입으로 apple 스피커가 적용됨
		lg_tv.volumeDown();
		factory.close();
	}

}

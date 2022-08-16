package polymorphism;

import org.springframework.stereotype.Component;

//@Component("apple")
public class AppleSpeaker implements Speaker {

	//기본생성자
	public AppleSpeaker() {
		super();
		System.out.println("애플스피커(1) 객체생성");
	}
	
	
	
	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker --소리올림");
	}


	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker --소리내림");
		
	}

	
	
}

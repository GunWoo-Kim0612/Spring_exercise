package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lg")
public class LgTV implements TV{
	
	@Autowired
//	@Qualifier("apple")
	private Speaker speaker;
	
	
	
	
	public LgTV() {
		super();
		System.out.println("lg객체 생성 싱글톤");
	}
	public void powerOn() {
		System.out.println("LGTV --- 전원켠다.");
	}
	public void powerOff() {
		System.out.println("LGTV --- 전원끈다.");
	}
	public void volumeUp() {
//		System.out.println("LGTV --- 소리 올린다.");
		speaker.volumeUp();
	}
	public void volumeDown() {
//		System.out.println("LGTV --- 소리 내린다.");
		speaker.volumeDown();
	}
}

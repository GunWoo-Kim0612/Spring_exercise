package polymorphism;

import lombok.Setter;

@Setter
public class SamsungTV implements TV {
	
	//멤버변수
	private Speaker speaker;
	private int price;
	
	
	//source  generate object from superclass
	public SamsungTV() {
		super();
		System.out.println("삼성객체(1)생성");
	}
	
	
	//
	public SamsungTV(Speaker speaker) {
		super();
		System.out.println("삼성객체(2)생성");
		this.speaker = speaker;
	}
	
	
	//스피커, 가격 동시에 주입받는 생성자
	public SamsungTV(Speaker speaker, int price) {
		super();
		System.out.println("삼성객체(3)생성");
		this.speaker = speaker;
		this.price = price;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//
//	public void setSpeaker(speaker speaker) {
//		this.speaker = speaker;
//	}
//	
//	public void setPrice(int price) {
//		this.price= price;
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void powerOn() {
		System.out.println("Samsung --- 전원켠다. (가격 : "+ price  +  ")");
	}
	public void powerOff() {
		System.out.println("Samsung --- 전원끈다.");
	}

	public void volumeDown() {
		//안좋다.
//		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
	@Override
	public void volumeUp() {
//		speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	
}

package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Data;

@Data

public class SamsungTV implements TV {
	
	@Autowired	
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 객체 생성");
	}
	
	public void setSpeaker(Speaker speaker) { // setter메소드 의존주입 방식
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) { // setter메소드 의존주입 방식
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}
	
	
//	public SamsungTV(Speaker speaker) { // 생성자 의존주입
//		System.out.println("===> SamsungTV(2) 객체 생성");
//		this.speaker = speaker;
//	}
//
//	public SamsungTV(Speaker speaker, int price) { // 생성자 의존주입
//		System.out.println("===> SamsungTV(3) 객체 생성");
//		this.speaker = speaker;
//		this.price = price;
//	}


	public void powerOn() {
	      System.out.println("SamsungTV---전원 켠다.(가격 : " + price + ")");
	   }

	   public void powerOff() {
	      System.out.println("SamsungTV---전원 끈다.");
	   }

	   public void volumeUp() {
		  speaker.volumeUp();
	   }

	   public void volumeDown() {
		   speaker.volumeDown();
	   }
}

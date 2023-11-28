package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv") // xml파일의 component-scan의 대상, 괄호 안의 문자열은 xml 객체 생성 때 사용했던 id 값과 같은 역할
public class LgTV implements TV{
	
	@Autowired // 자동 의존주입(xml에 일일이 등록할 필요가 없음), 그러나 speaker 중 apple인지 sony인지 모름 
	@Qualifier("sony") // 그래서 Autowired를 사용할 때, Qualifier를 같이 사용하며 Qualifier에 원하는 id값을 같이 작성한다.
	
	private Speaker speaker;
	
	public void powerOn() {
	      System.out.println("LgTV---전원 켠다.");
	   }

	   public void powerOff() {
	      System.out.println("LgTV---전원 끈다.");
	   }

	   public void volumeUp() {
		   speaker.volumeUp();
	   }

	   public void volumeDown() {
	      speaker.volumeDown();
	   }
}

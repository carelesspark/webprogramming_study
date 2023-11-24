package polymorphism;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 클래스를 정의해서 사용하는 방식(Bean 등록)

@Configuration 
public class SpringConfig {

	@Bean
	public SamsungTV samsungTV() {
		return new SamsungTV();
	}
	@Bean
	public AppleSpeaker appleSpeaker() {
		return new AppleSpeaker();
	}
	
}

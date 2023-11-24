package polymorphism;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

public class TVUser {
	
	public static void main(String[] args) {
//		POJO(Plain Old Java Object)
//		- 직접 생성해서 사용하는 객체
//		- new Date()와 같이 직접 생성
//
//		nonPOJO
//		- 생성을 직접하지 않고 사용하는 객체
//		서블릿 객체 -> applicationContext.xml 내의 bean태그
//
//		lOC(Inversion Of Control
//		- 제어의 역전
//		- 객체등록방식
//		- 1. <bean>태그 사용 방식
//		- 2. 어노테이션(@) 사용 방식 => @Component("아이디 값")
//		<context:component-scan base-package="polymorphism"></context:component-scan>
//		@Component("tv"), @Controller, @Service, @Repository
//		- 3. 클래스를 정의해서 사용하는 방식
//		
//		DI(Dependency Injection)
//		- 의존주입
//		- 자동 의존주입
//		- 1. 생성자 의존주입 방식
//		- 2. setter메소드 의존주입 방식
//		- 3. 자동 의존주입
//		@Autowired // 자동주입 타입을 확인해서 bean을 주입한다.
//		@Qualifier("apple")
//
//		AOP(Aspect Oriented Praogamming
//		- 관점 기향 프로그래밍
//		- 공통 기능
		
		// applicationContext.xml에 객체 생성 전 BeanFactory.java와 같이 사용한 코드
		
//		BeanFactory factory = new BeanFactory(); 
//		Scanner sc = new Scanner(System.in);
//		System.out.println("tv명 입력 : ");
//		
//		String tvName = sc.nextLine();
//		TV tv = (TV)factory.getBean(tvName);
//		
		
		// 스프링에서는 스프링 컨테이너에서 객체를 제어하고 new로 시작하는 객체 생성방식은 거의 사용x
		// POJO방식 X IOC방식 O
		
		//	TV tv2 = (TV)factory.getBean("tv");
		//	TV tv3 = (TV)factory.getBean("tv");
		
		// 스프링은 객체 생성방식이 싱글톤 패턴(주소 값이 동일함)
		// 싱글톤이 아닌 방식으로 생성하려면 applicationContext에 정의한 객체 태그에 scope속성에 "prototype"값을 적용해야 한다.
		//	System.out.println(tv);
		//	System.out.println(tv2);
		//	System.out.println(tv3);
		
		// applicationContext.xml에 저장해 놓은 <bean>태그를 가져오기 위한 객체 생성 코드
		// AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// TV tv = (TV)factory.getBean("tv"); // getBean("id값") + TV 객체 타입으로 캐스팅
		
		
		// SpringConfig클래스를 정의해서 사용하는 방식(Bean 등록)
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		TV tv = ac.getBean(SamsungTV.class);
		

		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();

	}

}

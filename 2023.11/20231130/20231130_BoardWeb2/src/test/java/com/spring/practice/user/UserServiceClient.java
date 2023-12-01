package com.spring.practice.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)factory.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("1234");
		
		UserVO user = userService.getUser(vo);
		
		if(user != null) {
			System.out.println(user.getName() + "님 로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		
	}

}

package com.spring.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController{

	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) throws Exception {
		
		System.out.println("로그아웃 처리");	
		
		
		session.invalidate();
		return "redirect:login.jsp";
	}

}

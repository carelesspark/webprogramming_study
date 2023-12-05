package com.spring.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.practice.user.UserVO;
import com.spring.practice.user.impl.UserDAO;

@Controller
public class LoginController{

	@RequestMapping(value="/login.do")
	public String login(UserVO vo, UserDAO dao) throws Exception {
		
		System.out.println("로그인 처리");
		
//		String id = req.getParameter("id");
//		String password = req.getParameter("password");
//		
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		
//		UserDAO dao = new UserDAO();
//		UserVO user = dao.getUser(vo);
//		
//		ModelAndView mav = new ModelAndView();
		
		
		UserVO user = dao.getUser(vo);
		if(user != null) {
			return "redirect:getBoardList.do";
		} else {
			return "redirect:login.jsp";
		}
	}
}

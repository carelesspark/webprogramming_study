/* 전에 작성한 LoginController
 * 
 * package com.spring.view.user;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * import com.spring.practice.user.UserVO; import
 * com.spring.practice.user.impl.UserDAO;
 * 
 * @Controller public class LoginController{
 * 
 * @RequestMapping(value="/login.do") public String login(UserVO vo, UserDAO
 * dao) throws Exception {
 * 
 * System.out.println("로그인 처리");
 * 
 * // String id = req.getParameter("id"); // String password =
 * req.getParameter("password"); // // UserVO vo = new UserVO(); //
 * vo.setId(id); // vo.setPassword(password); // // UserDAO dao = new UserDAO();
 * // UserVO user = dao.getUser(vo); // // ModelAndView mav = new
 * ModelAndView();
 * 
 * 
 * UserVO user = dao.getUser(vo); if(user != null) { return
 * "redirect:getBoardList.do"; } else { return "redirect:login.jsp"; } } }
 */


package com.spring.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.practice.user.UserVO;
import com.spring.practice.user.impl.UserDAO;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("로그인 화면으로 이동...");
		vo.setId("test");
		vo.setPassword("1234");
		
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		
		System.out.println("로그인 처리");
		
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			session.setAttribute("userName", user.getName());
			return "redirect:getBoardList.do";
		} else {
			return "login.jsp";
		}

	}
}

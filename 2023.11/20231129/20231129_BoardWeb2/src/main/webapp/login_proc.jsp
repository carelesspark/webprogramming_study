<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.spring.practice.user.UserVO" %>
<%@ page import = "com.spring.practice.user.impl.UserDAO" %>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);

	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	if (user != null) {
		response.sendRedirect("./getBoardList.jsp");
	} else {
		response.sendRedirect("./login.jsp");
	}
			
%>
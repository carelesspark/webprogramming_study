<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="membership.MemberDTO"%>
<%@ page import="membership.MemberDAO"%>
<% 
	String userId = request.getParameter("user_id");
	String userPw = request.getParameter("user_pw");
	
	
	String driver = application.getInitParameter("OracleDriver");
	String url = application.getInitParameter("OracleUrl");
	String id = application.getInitParameter("OracleId");
	String pwd = application.getInitParameter("OraclePwd");
	
	MemberDAO dao = new MemberDAO(driver, url, id, pwd);
	MemberDTO memberDTO = dao.getMemberDTO(userId, userPw);
	
	if(memberDTO.getId() != null){
		// 로그인 성공
		session.setAttribute("userId", memberDTO.getId()); // 세션에 실제 ID값이 저장
		session.setAttribute("userName", memberDTO.getName()); // 세션에 실제 Name값이 저장
		request.setAttribute("LoginSuccessMsg", "로그인 성공");
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
	} else {
		// 로그인 실패
		request.setAttribute("LoginErrMsg", "로그인 실패");
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
	}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("userId");
	session.removeAttribute("userName");
	
	// session.invalidate(); session 전체 삭제
	
	response.sendRedirect("LoginForm.jsp");
%>
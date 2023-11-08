<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="utils.JSFunction" %>
<%
	if(session.getAttribute("userId") == null){
		JSFunction.alertLocation("로그인이 필요합니다.", "LoginForm.jsp", out);
		
		return;
	}

%>
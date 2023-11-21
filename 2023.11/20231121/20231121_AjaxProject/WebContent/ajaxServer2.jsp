<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String userid = request.getParameter("userid");
%>


{
	"loginId" : "<%= userid %>",
	"loginSuccess" : "님 로그인 성공"
}
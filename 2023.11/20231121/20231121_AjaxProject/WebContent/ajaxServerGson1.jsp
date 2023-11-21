<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.*"%>

<%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String message = " 님 로그인 성공";
	
	Gson gson = new Gson(); // gson라이브러리
	JsonObject obj = new JsonObject(); // gson라이브러리
	
	obj.addProperty("loginId", userid);
	obj.addProperty("loginSuccess", message);
	
	out.print(gson.toJson(obj));  
	
	
%>
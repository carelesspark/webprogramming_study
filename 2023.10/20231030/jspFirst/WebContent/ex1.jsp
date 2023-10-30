<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="FirstJsp.jsp" %> <!-- ex1.jsp = ex1.jsp + FirstJsp.jsp -->
<%
	// 지시자
	// <%@ page > : 현재 문서는 jsp 형식의 문서 입니다, 
	// <%@ include > : 문서 여러 개를 하나로 합치는 역할, 
	// <%@ taglib > : 문법의 정의를 태그 형식으로 작성
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	ex1.jsp에 FirstJsp.jsp를 include 함<br/>
	<%= today %>
</body>
</html>
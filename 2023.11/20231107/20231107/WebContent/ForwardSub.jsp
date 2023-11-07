<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String myName = request.getParameter("myName");
	String myAge = request.getParameter("myAge");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ForwardSub</title>
</head>
<body>
	page영역 정보 : <%= pageContext.getAttribute("pAttr") %><br/> <!-- null 값 출력 -->
	
	request영역 정보 : <%= request.getAttribute("rAttr") %><br/> <!-- request 속성 지정 출력 -->
	
	파라미터 정보 : <%= myName %>, <%= myAge %>
</body>
</html>
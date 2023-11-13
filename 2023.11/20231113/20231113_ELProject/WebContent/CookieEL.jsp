<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="utils.CookieManager" %>
<%
	request.setCharacterEncoding("utf-8");
	int num1 = 10;
	int num2 = 20;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
      CookieManager.makeCookie(response, "ELCookie", "EL값읽어오기", 10); // cValue값에 띄어쓰기 넣으면 오류 발생(주의)
   %>

	<p>EL쿠기값 : ${ cookie.ELCookie.value }</p>
	<p> 덧셈 : ${num1 + num2}</p>
	<p> 덧셈 : ${num1 - num2}</p>
</body>
</html>
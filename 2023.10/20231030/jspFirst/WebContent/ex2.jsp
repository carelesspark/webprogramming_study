<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int x = 10;
%>

<%!
	int y = 5;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= x %>
<%= y %>
	<!-- 스크립트 3요소 -->
	<!-- 지역변수, 진역변수가 아닌 선언  -->
	<!-- 선언 위치는 태그 위쪽 또는 body태그 안  -->

	<!-- 스크립틀릿 : 지역변수 위치-->
	<%-- <% 자바의 변수 선언, 메소드 정의, 반복문, 조건문 %> --%>

	<!-- 선언문 : 지역변수가 아닌 위치 -->
	<%-- <%! 자바의 변수 선언, 메소드 정의 %> --%>

	<!-- 표현식 : 출력기능 -->
	<%-- <%= 출력을 위한 값(함수, 수식) %> --%>
</body>
</html>
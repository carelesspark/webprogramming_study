<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		EL(Expression Language)

		형식 : ${ 값 }
		
		- jsp내장객체의 속성을 사용할 수 있다.
		- 연산 가능
		- 자바의 메소드 호출
		- jsp처럼 파라미터도 받을 수 있음
		
		- 영역 객체
		pageContext, request, session, application
		공통함수 : setAttribute(), getAttribute()
		
		pageScope, requestScope, sessionScope, applicationScope
	*/
	
	pageContext.setAttribute("scopeValue", "페이지 영역");
	request.setAttribute("scopeValue", "리퀘스트 영역");
	session.setAttribute("scopeValue", "세션 영역");
	application.setAttribute("scopeValue", "어플리케이션 영역");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>objMain</title>
</head>
<body>
	<ul>
		<li>${pageScope.scopeValue}</li>
		<li>${requestScope.scopeValue}</li>
		<li>${sessionScope.scopeValue}</li>
		<li>${applicationScope.scopeValue}</li>
	</ul>
	
	<p>${scopeValue}</p> <!-- 페이지 영역 출력, 영역을 표시 하지 않을 경우 페이지 -> 리퀘스트 -> 세션 -> 어플리케이션 영역 순으로 출력한다 -->
	
	<jsp:forward page="forwardResult.jsp"></jsp:forward> <!-- 페이지가 이동했기에, 페이지 영역은 null이 되고 다음인 리퀘스트 영역부터 값이 출력 -->
</body>
</html>
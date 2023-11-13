<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="common.Person"%>
<%@ page import="java.util.*"%>

<%
	/* 	태그라이브러리(JSTL)
		
		- 자바코드를 대신해서 사용한다
		- 코드의 복잡성을 낮추는 역할
		<%@ taglib prifix="값" url="값"> */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL1</title>
</head>
<body>
	<!-- 변수 선언 (영역객체 : pageContext)-->
	<c:set var="directVar" value="100"></c:set>
	<c:set var="expVar" value="<%=new Date()%>"></c:set>
	<c:set var="elVar" value="${directVar mod 5}"></c:set>
	<c:set var="betweenVar" scope="request">변수 값을 이렇게 작성 가능</c:set>
	<!-- scope속성으로 영역 객체 저장 가능 -->

	<p>directVar : ${directVar}</p>
	<%-- == ${pageScope.directVar} --%>
	<p>elVar : ${elVar}</p>
	<%-- == ${pageScope.elVar} --%>

	<hr />

	<c:set var="personVar1" value='<%=new Person("박종혁", 22)%>'
		scope="request" />

	<p>${requestScope.personVar1.name}</p>


</body>
</html>
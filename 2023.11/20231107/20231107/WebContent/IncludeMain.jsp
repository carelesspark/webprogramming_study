<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String outerPath1 = "./inc/OuterPage1.jsp";
	String outerPath2 = "./inc/OuterPage2.jsp";
	
	pageContext.setAttribute("pAttr", "변수 생성");
	request.setAttribute("rAttr", "변수 생성");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IncludeMain</title>
</head>
<body>
	<!-- 1. 컴파일시 하나의 파일로 합쳐진다.
	2. 경로정보를 변수로 처리 불가 -->
	<%@ include file="./inc/OuterPage1.jsp" %>
	<p>외부 파일에 선언한 변수 : <%= newVar1 %></p>  
	
	
	<!-- 1. 런타임시 하나의 파일로 합쳐진다.
	2. 경로정보를 변수로 처리 가능 -->
	<jsp:include page="<%=outerPath2 %>" /> <!-- page 영역 속성에는 값이 들어가지 않음 -->
	<jsp:include page="./inc/OuterPage2.jsp" />
	<p>외부 파일에 선언한 변수: <%-- <%= newVar2 %> --%></p>
</body>
</html>
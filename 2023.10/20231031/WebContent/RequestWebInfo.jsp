<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// http://localhost:8000/20231031/RequestWebInfo.jsp?eng=Hello&kor=%EC%95%88%EB%85%95
	
	request.setCharacterEncoding("utf-8"); // post방식의 경우 한글이 깨지기에 이 코드를 통해 깨짐을 방지
	
	String eng = request.getParameter("eng");
	String kor = request.getParameter("kor");
	
	String url = request.getRequestURL().toString();
	String uri = request.getRequestURI();
	
	String queryString = request.getQueryString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestWebInfo</title>
</head>
<body>
eng : <%= eng %><br/>
kor : <%= kor %><br/>
url : <%= url %><br/>
uri : <%= uri %><br/>
queryString : <%= queryString %><br/> <!-- Get방식에서만 나오고 Post방식에서는 나오지 않음 -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> <!-- Enumeration 타입을 사용하기 위한 import -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestHeader</title>
</head>
<body>
	<%
		/* 헤더의 정보들을 어떻게 가져오는지에 대한 코드 */
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			String headerName = headers.nextElement();
			String headerValue = request.getHeader(headerName);
			out.print("headerName : " + headerName + "<br/>" + "headerValue : " + headerValue);
		}
	%>
</body>
</html>
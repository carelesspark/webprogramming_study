<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>

<%
	SimpleDateFormat s = new SimpleDateFormat("yyyy-mm-dd");
	long add_date = s.parse(request.getParameter("add_date")).getTime();
	int add_int = Integer.parseInt(request.getParameter("add_int"));
	String add_str = request.getParameter("add_str");
	
	// response의 header영역에 값 추가	
	response.addDateHeader("myBirthday", add_date);
	response.addIntHeader("myNumber", add_int);
	response.addIntHeader("myNumber", 1004);
	response.addHeader("myName", add_str);
	response.addHeader("myName", "박종혁");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ResponseHeader</title>
</head>
<body>
	<%
		Collection<String> headerNames = response.getHeaderNames();
		for(String hName : headerNames){
			String hValue = response.getHeader(hName);
	%>
	
	<p><%= hValue %></p>
	
	<%
		}
	%>
</body>
</html>
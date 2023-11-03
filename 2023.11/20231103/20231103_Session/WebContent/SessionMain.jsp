<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<%
	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	long creationTime = session.getCreationTime();
	String timeStr = dateFormat.format(new Date(creationTime));
	long lastTime = session.getLastAccessedTime();
	String lastStr = dateFormat.format(new Date(lastTime));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SessionMain</title>
</head>
<body>
	<p><%= timeStr %></p>
	<p><%= session.getCreationTime() %></p>
	<p><%= session.getId() %></p>
	<p><%= lastStr %></p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ApplicationName</title>
</head>
<body>
	<h2><%= application.getInitParameter("INIT_PARAM") %></h2> <!-- web.xml에 저장된 값을 불러옴 -->
	
	<h2><%= application.getRealPath("/") %></h2> <!-- 톰캣이 관리하는 실제 경로 -->
</body>
</html>
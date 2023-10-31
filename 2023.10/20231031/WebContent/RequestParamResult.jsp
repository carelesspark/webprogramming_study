<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String gender = request.getParameter("gender");
	String[] hobby = request.getParameterValues("hobby"); // 배열 형태로 값 받기
	String job = request.getParameter("job");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestParamResult</title>
</head>
<body>
	성별 :
	<%= gender %>
	<br /> 
	관심사항 :
	<%
	for(int i = 0; i < hobby.length; i++){
	%>
		<%= hobby[i] + " "%>
	<%
	}
	%><br/>
	직업 :
	<%= job %>
	


</body>
</html>
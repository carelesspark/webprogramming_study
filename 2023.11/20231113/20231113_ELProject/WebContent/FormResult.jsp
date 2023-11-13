<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FormResult</title>
</head>
<body>
	<ul>
		<!-- 첫 번째 방식 -->
		<li>${param.name}</li>
		<li>${param.gender}</li>
		<li>${param.grade}</li>
		<li>
			${paramValues.inter[0]}
			${paramValues.inter[1]}
			${paramValues.inter[2]}
			${paramValues.inter[3]}
		</li> <!-- 체크박스는 여러 개 받기 때문에 paramValues 작성 -->
	</ul>
	<hr>
	<ul>
		<!-- 두 번째 방식 -->
		<li>${param['name']}</li>
		<li>${param['gender']}</li>
		<li>${param['grade']}</li>
		<li>
			${paramValues.inter[0]}
			${paramValues.inter[1]}
			${paramValues.inter[2]}
			${paramValues.inter[3]}
		</li> <!-- 체크박스는 여러 개 받기 때문에 paramValues 작성 -->
	</ul>
</body>
</html>
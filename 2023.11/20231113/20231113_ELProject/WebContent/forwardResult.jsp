<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forwardResult</title>
</head>
<body>
	<ul>
		<li>${pageScope.scopeValue}</li>
		<li>${requestScope.scopeValue}</li>
		<li>${sessionScope.scopeValue}</li>
		<li>${applicationScope.scopeValue}</li>
	</ul>
	
	<p>${scopeValue}</p>
</body>
</html>
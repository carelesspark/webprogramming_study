<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL3</title>
</head>
<body>
	<c:set var="number" value="100" />
	<c:set var="string" value="JSP" />
	
	<c:if test="${number mod 2 eq 0}" var="result">
		${number}은/는 짝수입니다.
	</c:if>
	<br/>
	result = ${result} <br/>
	
	<c:if test="${string eq 'Java'}" var="result2">
		문자열은 'Java'입니다.
	</c:if>
	<br/>
	result2 = ${result2}<br/>
	
	<c:choose>
		<c:when test="${number mod 2 eq 0 }">${number}는 짝수 입니다.</c:when>
		<c:when test="${number mod 2 ne 0 }">${number}는 홀수 입니다.</c:when>
		<c:otherwise>${"잘못 입력했습니다."}</c:otherwise>
	</c:choose>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL4</title>
</head>
<body>
	<h4>국,영,수 점수를 입력하면 평균을 내어 학점 출력</h4>
	<form>
		<!-- 점수 입력 폼 -->
		국어 : <input type="text" name="kor" /> <br /> 영어 : <input type="text"
			name="eng" /> <br /> 수학 : <input type="text" name="math" /> <br />
		<input type="submit" value="학점 구하기" />
	</form>
	<c:if
		test="${not (empty param.kor or empty param.eng or empty param.math)}">
		<c:set var="avg" value="${(param.kor + param.eng + param.math) / 3}" />
		<!-- el은 기본적으로 파라미터 값을 사용할 수 있는데 이는 영역 객체에서 가져온다, 파라미터는 보통 리퀘스트 객체에서 가져옴 -->
		<c:choose>
			<c:when test="${avg >= 90}">A학점</c:when>
			<c:when test="${avg >= 80}">B학점</c:when>
			<c:when test="${avg >= 70}">C학점</c:when>
			<c:when test="${avg >= 60}">D학점</c:when>
			<c:otherwise>F학점</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>
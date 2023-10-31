<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestMain</title>
</head>
<body>
	<a href="./RequestWebInfo.jsp?eng=Hello&kor=안녕">Get방식 전송</a> <!-- 주소 창에 값이 넘어가는 게 보임 -->
	
	<form action="./RequestWebInfo.jsp" method="post"> <!-- 주소 창에 값이 넘어가는게 보이지 않음 -->
		영어 : <input type="text" name="eng" value="Bye" /> <br/> 
		한글 : <input type="text" name="kor" value="잘가" /> <br/>
		<input type="submit" value="Post방식 전송" /> 
	</form>
</body>
</html>
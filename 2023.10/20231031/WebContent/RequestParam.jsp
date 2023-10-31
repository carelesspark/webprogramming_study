<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestParam</title>
</head>
<body>
	<form action="./RequestParamResult.jsp" method="post">
		성별 : <input type="radio" name="gender" value="male" />남성 
			 <input type="radio" name="gender" value="female" />여성
		<br/> <br/>
		
		
		 관심사항 : <input type="checkbox" name="hobby" value="eco" /> 경제
		<input type="checkbox" name="hobby" value="poly" /> 정치 
		<input type="checkbox" name="hobby" value="musi" /> 문화
		
		<br/><br/>
		
		직업 :
		<select name="job">
			<option value="student">학생</option>
			<option value="company">회사원</option>
			<option value="teacher">교사</option>
		</select>
		
		<br/><br/>
		
		<input type="submit" value="전송" />
	</form>


</body>
</html>
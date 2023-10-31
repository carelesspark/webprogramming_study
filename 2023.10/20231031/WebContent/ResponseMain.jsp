<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String loginErr = request.getParameter("loginErr");

	if(loginErr != null){
		out.print("로그인 실패");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ResponseMain</title>
</head>
<body>
	<form action="./ResponseLogin.jsp" method="post">
		아이디 : <input type="text" name="id" /><br/>
		비밀번호 : <input type="password" name="pw" /><br/>
		<input type="submit" value="로그인" />
	</form>
	
	<form action="./ResponseHeader.jsp" method="get">
		날짜 형식 : <input type="text" name="add_date" value="2023-10-31" /><br/> 
		숫자 형식 : <input type="text" name="add_int" value="8282" /><br/> 
		문자 형식 : <input type="text" name="add_str" value="park" /><br/> 
		
		<input type="submit" value="응답 헤더 설정" />
	</form>
</body>
</html>
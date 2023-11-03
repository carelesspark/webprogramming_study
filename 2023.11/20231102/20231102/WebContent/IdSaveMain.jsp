<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="utils.CookieManager"%>
<%
	String loginId = CookieManager.readCookie(request, "loginId");

	String cookieCheck = "";
	if (!loginId.equals("")) {
		cookieCheck = "checked";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IdSaveMain</title>
</head>
<body>
	<form action="IdSaveProcess.jsp" method="post">
		아이디 : <input type="text" name="user_id" value="<%=loginId%>"><br>
		비밀번호 : <input type="password" name="user_pw"><br> <input
			type="checkbox" name="save_check" value="Y" <%=cookieCheck%>>아이디
		저장<br> <input type="submit" value="로그인">
	</form>
</body>
</html>
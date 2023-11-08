<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.board.BoardDAO"%>
<%@ page import="model1.board.BoardDTO"%>
<%
	String num = request.getParameter("num");

	BoardDAO dao = new BoardDAO(application);
	// 1. 조회수 증가
	dao.updateVisitCount(num);
	
	// 2. 해당 글의 상세 정보 조회
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
</head>
<body>

</body>
</html>
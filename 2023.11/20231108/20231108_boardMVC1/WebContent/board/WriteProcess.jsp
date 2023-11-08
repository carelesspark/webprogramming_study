<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model1.board.BoardDAO"%>
<%@ page import="model1.board.BoardDTO"%>
<%@ include file="IsLoggedIn.jsp"%>
<%
	request.setCharacterEncoding("utf-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	BoardDTO dto = new BoardDTO();
	dto.setTitle(title);
	dto.setContent(content);
	dto.setId(session.getAttribute("userId").toString());

	BoardDAO dao = new BoardDAO(application);

	int result = dao.insertWrite(dto);

	if (result > 0) { // 성공
		response.sendRedirect("List.jsp");
	} else {
		JSFunction.alertBack("글쓰기 실패", out);
	}
%>
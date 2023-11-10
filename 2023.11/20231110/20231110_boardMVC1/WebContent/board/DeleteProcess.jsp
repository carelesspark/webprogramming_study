<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model1.board.BoardDAO"%>
<%@ page import="model1.board.BoardDTO"%>
<%@ include file="IsLoggedIn.jsp"%>
<%
	String num = request.getParameter("num");

	BoardDAO dao = new BoardDAO(application);
	BoardDTO dto = new BoardDTO();

	dto.setNum(num);
	int result = dao.deletePost(dto);

	dao.close();
	if (result > 0) {
		// 성공 시 List.jsp 이동
		JSFunction.alertLocation("삭제에 성공했습니다", "List.jsp", out);
	} else {
		// 실패 시 View.jsp(history.back)이동
		JSFunction.alertBack("삭제에 실패했습니다.", out);
	}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model1.board.BoardDAO"%>
<%@ page import="model1.board.BoardDTO"%>
<%@ include file="IsLoggedIn.jsp"%>
<%
	request.setCharacterEncoding("utf-8");
	String num = request.getParameter("num");
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	BoardDTO dto = new BoardDTO();

	dto.setNum(num);
	dto.setTitle(title);
	dto.setContent(content);

	BoardDAO dao = new BoardDAO(application);

	int result = dao.updateEdit(dto);

	dao.close();

	if (result > 0) {
		response.sendRedirect("View.jsp?num=" + dto.getNum()); // 그냥 View.jsp를 보내주면 누구의 게시글인지 알 수 없기 때문에 다시 수정한 해당 글의 num을 같이 send해줘야 함
	} else {
		JSFunction.alertBack("게시글 수정에 실패하였습니다.", out);
	}
%>
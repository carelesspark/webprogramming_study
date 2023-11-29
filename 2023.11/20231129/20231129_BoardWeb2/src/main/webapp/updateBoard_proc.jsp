<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spring.practice.board.BoardVO"%>
<%@ page import="com.spring.practice.board.impl.BoardDAO"%>
<%
	
	request.setCharacterEncoding("utf-8");

	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String seq = request.getParameter("seq");
	
	BoardVO vo = new BoardVO();
	BoardDAO dao = new BoardDAO();
	
	vo.setSeq(Integer.parseInt(seq));
	vo.setTitle(title);
	vo.setContent(content);
	
	dao.updateBoard(vo);
	response.sendRedirect("./getBoardList.jsp");
	
	
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spring.practice.board.BoardVO"%>
<%@ page import="com.spring.practice.board.impl.BoardDAO"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	
	BoardVO vo = new BoardVO();
	BoardDAO dao = new BoardDAO();
	
	vo.setTitle(title);
	vo.setWriter(writer);
	vo.setContent(content);
	
	dao.insertBoard(vo);

	response.sendRedirect("./getBoardList.jsp");
%>
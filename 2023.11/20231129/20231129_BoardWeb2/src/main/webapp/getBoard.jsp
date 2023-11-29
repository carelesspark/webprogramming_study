<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.spring.practice.board.BoardVO"%>
<%@ page import="com.spring.practice.board.impl.BoardDAO"%>
<%@page import="java.util.List"%>
<%
	BoardVO vo = new BoardVO();
	BoardDAO dao = new BoardDAO();

	String seq = request.getParameter("seq");

	vo.setSeq(Integer.parseInt(seq));
	BoardVO user = dao.getBoard(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 게시글</title>
</head>
<body>
	<center>
		<h1>글 상세</h1>
		<a href="logout_proc.jsp">Log-out</a>
		<hr>
		<form action="updateBoard_proc.jsp" method="post">
			<input type="hidden" name="seq" value="<%= user.getSeq() %>" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input name="title" type="text"
						value="<%=user.getTitle()%>" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left"><%=user.getWriter()%></td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10"><%=user.getContent()%></textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left"><%=user.getRegDate()%></td>
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td align="left"><%=user.getCnt()%></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="글 수정" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoard.jsp">글 동록</a>&nbsp;&nbsp;&nbsp; <a
			href="deleteBoard_proc.jsp?seq=<%=user.getSeq()%>">글 삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.jsp">글 목록</a>
	</center>
</body>
</html>
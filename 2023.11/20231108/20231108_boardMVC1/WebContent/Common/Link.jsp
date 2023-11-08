<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table border="1" width="90%">
	<tr align="center">
		<td>
			<%
				if(session.getAttribute("userId") == null){
					
			%>
			<a href="LoginForm.jsp">로그인</a>
			
			<% } else { %>
			
			<a href="Logout.jsp">로그아웃</a>
			<% } %>
		</td>
		<td>
			<a href="List.jsp">게시판(페이징X)</a>
		</td>
		<td>게시판(페이징O)</td>
	</tr>
</table>
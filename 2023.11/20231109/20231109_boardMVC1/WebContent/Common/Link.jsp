<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table border="1" width="90%">
	<tr align="center">
		<td>
			<%
				if (session.getAttribute("userId") == null) {
			%> <a href="LoginForm.jsp">로그인</a> <%
 	} else {
 %> <a href="Logout.jsp">로그아웃</a> <%
 	}
 %>
		</td>
		<td><a href="List.jsp">게시판(페이징X)</a></td>
		<td><a href="List2.jsp">게시판(페이징O)</a></td>
	</tr>
</table>

<!-- 페이징 시 필요한 정보

1. 전체 게시글의 갯수
2. 한 블럭당 표시해야하는 페이지의 갯수
3. 한 페이지당 표시해놓는 글의 갯수
4. 페이지의 시작 번호와 끝 번호 계산
5. 최신글의 페이지별로 10개씩 보여주기 위한 쿼리문 구성

- 현재 페이지의 게시물 갯수
	POSTS_PER_PAGE = 10
- 한 화면(블럭)에 출력할 페이지 번호
	POSTS_PER_BLOCK = 5 -->
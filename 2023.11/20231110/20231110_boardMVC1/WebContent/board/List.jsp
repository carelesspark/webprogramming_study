<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model1.board.BoardDAO"%>
<%@ page import="model1.board.BoardDTO"%>
<%@ page import="java.util.*"%>

<%
	Map<String, Object> param = new HashMap<>();

	String searchField = request.getParameter("searchField");
	String searchWord = request.getParameter("searchWord");

	if (searchWord != null) {
		param.put("searchField", searchField);
		param.put("searchWord", searchWord);
	}

	BoardDAO dao = new BoardDAO(application);
	int totalCount = dao.selectCount(param);
	List<BoardDTO> boardLists = dao.selectList(param);

	dao.close();
	// 꼭 데이터 집어넣었으면,..... 커밋하자........ 오류 해결............
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<jsp:include page="../Common/Link.jsp" />

	<h2>목록 보기(List)</h2>

	<!-- 검색폼 -->

	<form method="get">
		<!-- action 속성이 정의 되지 않으면 현재 페이지로 이동해라 -->
		<table border="1" width="90%">
			<tr align="center">
				<td><select name="searchField">
						<option value="title">제목</option>
						<option value="content">내용</option>
				</select> <input type="text" name="searchWord" /> <input type="submit"
					value="검색" /></td>
			</tr>

		</table>
	</form>
	<table border="1" width="90%">
		<tr>
			<th width="10%">번호</th>
			<th width="50%">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
		</tr>
		<%
			if (boardLists.isEmpty()) {
		%>
		<tr>
			<td colspan="5" align="center">등록되어 있는 게시물이 없습니다.</td>
		</tr>
		<%
			} else {
				int vNum = 0;
				for (BoardDTO dto : boardLists) {
					vNum = totalCount--;
		%>
		<tr align="center">
			<td><%=vNum%></td>
			<td><a href="View.jsp?num=<%=dto.getNum()%>"><%=dto.getTitle()%></a>
			</td>
			<td><%=dto.getId()%></td>
			<td><%=dto.getVisitcount()%></td>
			<td><%=dto.getPostdate()%></td>
		</tr>
		<%
			}
			}
		%>
	</table>
	<table border="1" width="90%">
		<tr align="right">
			<td>
				<button type="button" onclick="location.href='Write.jsp';">글쓰기</button>
			</td>
		</tr>
	</table>
</body>
</html>
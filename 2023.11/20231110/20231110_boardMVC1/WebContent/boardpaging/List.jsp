<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model1.board.BoardDAO"%>
<%@ page import="model1.board.BoardDTO"%>
<%@ page import="java.util.*"%>
<%@ page import="utils.BoardPage" %>

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
	
	 // 전체 페이지 수 계산(web.xml에 POSTS_PER_PAGE, POSTS_PER_BLOCK값 저장)
	 int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
	 int blockPage = Integer.parseInt(application.getInitParameter("POSTS_PER_BLOCK"));
	 int totalPage = (int)Math.ceil((double)totalCount/pageSize);
	 
	 
	 // 현재 페이지 확인
	 int pageNum = 1;
	 String pageTemp = request.getParameter("pageNum");
	 if(pageTemp != null && !pageTemp.equals("")){
		 pageNum = Integer.parseInt(pageTemp);
	 }
	 
	 // 페이지 블록 설정(ex. 1~10, 11~20)
	 int start = (pageNum - 1) * pageSize + 1;
	 int end = (pageNum * pageSize);
	 
	 param.put("start", start);
	 param.put("end", end);
	 
	 List<BoardDTO> boardLists = dao.selectListPage(param);
	 
	// List<BoardDTO> boardLists = dao.selectList(param);

	dao.close();
	
	
	// 페이징 리스트 방법
	// 시작값 : (현재페이지 - 1) * POSTS_PER_PAGE + 1
	// 종료값 : (현재페이지 * POSTS_PER_PAGE)
	
	// 전체페이지 수 : 11개 ( 현재 게시글 105개 )
	// Math.ceil(107/10) => 11
	
	// 이전 블럭 가기
	// 1 페이지 : 1
	// 2 페이지 : 6
	// 3 페이지 : 11
	// pageTemp = ((현재페이지 - 1) / POSTS_PER_BLOCK) * POSTS_PER_BLOCK + 1
	
	// 페이지 번호
	// pageNum를 사용하여 해당 블럭에 페이지 번호를 출력한다.
	
	// 다음 블럭 가기
	// pageTemp + 1 : 다음 블럭가기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<jsp:include page="../Common/Link.jsp" />

	<h2>목록 보기(PagingList) - 현재 페이지 : <%= pageNum %> 전체 : <%= totalPage %></h2>

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
				int countNum = 0;
				for (BoardDTO dto : boardLists) {
					vNum = totalCount - (((pageNum - 1) * pageSize) + countNum++);
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
		<tr align="center">
			<td>
				<%= BoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, request.getRequestURI()) %> <!-- 예시) 1 2 3 4 5 -->
			</td>
			<td>
				<button type="button" onclick="location.href='Write.jsp';">글쓰기</button>
			</td>
		</tr>
	</table>
</body>
</html>
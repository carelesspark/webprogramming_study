<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<h2>파일 첨부형 게시판 - 목록 보기(List)</h2>

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
			<th width="5%">번호</th>
			<th width="50%">제목</th>
			<th width="15%">작성자</th>
			<th width="5%">조회수</th>
			<th width="15%">작성일</th>
			<th width="10%">다운횟수</th>
		</tr>
		<c:choose>
			<c:when test="${empty boardLists}">
				<tr>
					<td colspan="5" align="center">등록되어 있는 게시물이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${boardLists}" var="row" varStatus="loop">
					<tr align="center">
						<td>${params.totalCount - (((params.pageNum - 1) * params.pageSize) + loop.index)}</td>
						<td>${row.title}</td>
						<td>${row.name}</td>
						<td>${row.visitcount}</td>
						<td>${row.postdate}</td>
						<td>[Down]</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<table border="1" width="90%">
		<tr align="center">
			<td width="80%">${params.pageString}</td>
			<td width="20%">
				<button type="button" onclick="location.href='./write.do';">글쓰기</button> 
				<!-- index의 a.href의 경우 mvcboard/를 붙여줬는데 위 처럼 location.href의 경우에는 이미 mvcboard 경로가 포함되어 있어서 write.do만 작성 -->
			</td>
		</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model1.board.BoardDAO"%>
<%@ page import="model1.board.BoardDTO"%>

<%
	request.setCharacterEncoding("utf-8");
	String num = request.getParameter("num");

	BoardDAO dao = new BoardDAO(application);
	// 1. 조회수 증가
	dao.updateVisitCount(num);

	// 2. 해당 글의 상세 정보 조회
	BoardDTO dto = dao.selectView(num);
	dao.close();
%>

<!-- javascript 이벤트 처리 및 페이지 이동방식
1. <form action ="" method ="">
    <button type="submit">

2. <button onclick="location.href=''">

3. <button onclick="함수호출()">
    <script>function 함수호출(){ 
	form.action=""
	form.method=""
	form.submit();  } </script> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
<script>
	function deletePost() {
		var confirmed = confirm("정말로 삭제하겠습니까?");
		if (confirmed) {
			var form = document.viewForm;
			form.action = "DeleteProcess.jsp";
			form.method = "post";
			form.submit();
		}
	}
</script>
</head>
<body>
	<jsp:include page="../Common/Link.jsp" />
	<h2>회원제 게시판 - 상세 보기(View)</h2>

	<form name="viewForm">
		<input type="hidden" name="num" value="<%=num%>" />
		<table border="1" width="90%">
			<tr>
				<td>번호</td>
				<td><%=dto.getNum()%></td>
				<td>작성자</td>
				<td><%=dto.getName()%></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><%=dto.getPostdate()%></td>
				<td>조회수</td>
				<td><%=dto.getVisitcount()%></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3"><%=dto.getTitle()%></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3" height="100"><%=dto.getContent().replace("\r\n", "<br/>")%></td>
				<!-- 내용에 띄어쓰기를 적용하고 데이터베이스로 전송했을 때 데이터베이스에서는 <br/>를 \r\n으로 저장하기 때문에 
				이를 다시 jsp에 뿌려줄 때 이 \r\n을 <br/>태그로 변경한다는 의미(replace메소드) -->
			</tr>
			<tr>
				<td colspan="4" align="center">
					<%
						if (session.getAttribute("userId") != null
								&& session.getAttribute("userId").toString().equals(dto.getId())) {
					%>
					<button type="button"
						onclick="location.href='Edit.jsp?num=<%=dto.getNum()%>'">수정</button>
					<button type="button" onclick="deletePost()">삭제</button> <%
 	}
 %>
					<button type="button" onclick="location.href='List.jsp';">목록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
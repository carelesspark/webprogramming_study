<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fileupload.MyfileDTO" %>
<%@ page import="fileupload.MyfileDAO" %>
<%@ page import="java.util.*" %>
<%
	MyfileDAO dao = new MyfileDAO();
	List<MyfileDTO> list = dao.myFileList();
	
	dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FileList</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>No.</th>
			<th>작성자</th>
			<th>제목</th>
			<th>카테고리</th>
			<th>원본 파일명</th>
			<th>저장된 파일명</th>
			<th>작성일</th>
			<th></th>
		</tr>
		<% for(MyfileDTO f : list){ %>
		<tr>
			<td><%= f.getIdx()%></td>
			<td><%= f.getName()%></td>
			<td><%= f.getTitle()%></td>
			<td><%= f.getCate()%></td>
			<td><%= f.getOfile()%></td>
			<td><%= f.getSfile()%></td>
			<td><%= f.getPostdate()%></td>
			<td></td>
		</tr>
		<%} %>
	</table>
</body>
</html>
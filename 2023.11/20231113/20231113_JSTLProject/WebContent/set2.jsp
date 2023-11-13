<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="common.Person"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL2</title>
</head>
<body>
	<%
		ArrayList<Person> pList = new ArrayList<Person>();
		pList.add(new Person("박종혁", 22));
		pList.add(new Person("가나다", 50));
	%>

	<c:set var="pList1" value="<%=pList.get(0)%>" scope="request" />
	<c:set var="pList2" value="<%=pList.get(1)%>" scope="request" />

	<p>○ 첫 번째 리스트 : ${requestScope.pList1.name},
		${requestScope.pList1.age}</p>
	<p>○ 두 번째 리스트 : ${requestScope.pList2.name},
		${requestScope.pList2.age}</p>


	<%
		Map<String, Person> pMap = new HashMap<String, Person>();
		pMap.put("personArgs1", new Person("박종혁", 22));
		pMap.put("personArgs2", new Person("가나다", 42));
	%>

	<c:set var="pMap1" value='<%=pMap.get("personArgs1")%>'
		scope="request" />
	<c:set var="pMap2" value='<%=pMap.get("personArgs2")%>'
		scope="request" />

	<p>○ 첫 번째 맵 : ${requestScope.pMap1.name}, ${requestScope.pMap1.age}
	</p>
	<p>○두 번째 맵 : ${requestScope.pMap2.name}, ${requestScope.pMap2.age}
	</p>

	<%-- 변수 삭제는 <c:remove var="변수 이름" scope="request" /> --%>
</body>
</html>
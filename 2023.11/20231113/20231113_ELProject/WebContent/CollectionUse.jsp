<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="common.Person"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CollectionUse</title>
</head>
<body>
	<h2>List 컬렉션</h2>

	<%
		List<Object> aList = new ArrayList<>();
		aList.add("안녕하세요");
		aList.add(new Person("박종혁", 22));
		pageContext.setAttribute("Introduce", aList);
	%>

	<ul>
		<li>${Introduce[0]}</li>
		<%-- ${Introduce.get(0)} --%>
		<li>${Introduce[1].name},${Introduce[1].age}</li>
		<li>${Introduce[2]}</li>
	</ul>


	<h2>Map 컬렉션</h2>

	<%
		Map<String, String> map = new HashMap<>();
		map.put("한글", "Korean");
		map.put("영어", "English");
		pageContext.setAttribute("Language", map);
	%>

	<ul>
		<li>${Language["한글"]}</li>
		<%-- ${Language.get("한글")} --%>
		<li>${Language['한글']}</li>
		<%-- <li>${Language.한글}</li> --%>
		<!-- 한글은 직접참조 불가능/영어는 가능 -->
	</ul>
	
	<%
		pageContext.setAttribute("num1", 10);
		pageContext.setAttribute("num2", 20);
	%>
	<p>${num1 + num2}</p>


</body>
</html>
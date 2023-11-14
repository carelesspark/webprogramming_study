<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="common.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL5</title>
</head>
<body>
	<%-- <c:forEach begin="1" end="3" var="i" step="1">
		<p>${i}</p>
	</c:forEach>


	<c:forEach begin="3" end="5" var="i" varStatus="loop">
		<p>count : ${loop.count}</p> 
		<p>index : ${loop.index}</p>
		<p>current : ${loop.current}</p>
		<p>first : ${loop.first}</p>
		<p>last : ${loop.last}</p>
	</c:forEach> --%>
	
	
	<%-- <c:forEach begin="1" end="100" var="i" step="1">
		<c:if test="${i % 2 == 1}">
			<c:set var="total" value="${total + i}" />
		</c:if>
	</c:forEach>
	
	<h4>1에서 100까지 정수 중 홀수의 합 : ${total}</h4> --%>
	
	
	<%-- <%
		String[] rgba = {"Red", "Green", "Blue", "Black"};
	%>
	
	<c:forEach items="<%= rgba %>" var="c">
		<span style="color:${c};">${c}</span>
	</c:forEach> --%>
	
	
	<%-- <%
		LinkedList<Person> lists = new LinkedList<>();
		lists.add(new Person("박종혁", 22));
		lists.add(new Person("가나다", 42));
		lists.add(new Person("라마바", 32));
	
	%>
		<c:set var="lists" value="<%= lists %>" /> 
		<c:forEach items="${lists}" var="list">
			<ul>
				<li>이름 : ${list.name}, 나이 : ${list.age}</li>
			</ul>
		</c:forEach> --%>
		
		
	<%
		Map<String, Person> maps = new HashMap<>();	
		maps.put("1st", new Person("박종혁", 22));	
		maps.put("2st", new Person("가나다", 42));	
		maps.put("3st", new Person("라마바", 52));
	%>
	
		<c:set var="maps" value="<%= maps %>" />
		<c:forEach items="${maps}" var="map">
			<ul>
				<li>키 : ${map.key}, 이름 : ${map.value.name}, 나이 : ${map.value.age}</li>
			</ul>
		</c:forEach>
	
</body>
</html>
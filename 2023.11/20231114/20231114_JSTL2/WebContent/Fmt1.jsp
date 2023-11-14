<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL6</title>
</head>
<body>
	<c:set var="today" value="<%= new Date() %>" />
	
	full : <fmt:formatDate value="${today}" type="date" dateStyle="full"/>
	<br/>
	full : <fmt:formatDate value="${today}" type="time" timeStyle="full"/>
	<br/>
	full : <fmt:formatDate value="${today}" type="both" dateStyle="full" timeStyle="full"/>
	
</body>
</html>
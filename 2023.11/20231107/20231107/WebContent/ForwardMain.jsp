<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); // 넘겨준 값이 한글일 때 깨짐 방지
	
	
	pageContext.setAttribute("pAttr", "pageContext 속성 지정");
	request.setAttribute("rAttr", "request 속성 지정");

	// 페이지 이동
	/* 	Redirect(단순한 페이지 이동 request 객체를 새로 생성)
		response.senedRedirect();
		url이 해당 파일로 변경된다.
	
		forward(request, resopnse에 대한 제어권을 넘김)
		request.getRequestDispatcher().forward(request, response);
		url주소가 그대로 유지된다. */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ForwardMain</title>
</head>
<body>
	<%-- <jsp:forward page="ForwardSub.jsp" /> --%>
	<!-- 해당 페이지로 넘어가는데도 url은 Main으로 찍힘 => forward 이동 함수의 경우 url주소가 그대로 유지된다. -->

	<!-- 파라미터 정보 역시 넘길 수 있음 -->
	<!-- jsp:forward태그 내에 주석 처리하면 오류 발생! -->
	<jsp:forward page="ForwardSub.jsp">
		<jsp:param value="박종혁" name="myName" />
		<jsp:param value="22" name="myAge" />
	</jsp:forward>

</body>
</html>
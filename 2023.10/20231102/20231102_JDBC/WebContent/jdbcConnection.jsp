<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- DB 연결을 위한 import 코드 -->	
<%-- <%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %> --%> <!-- 보통은 이렇게 import함 -->

<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>

<%
	/* DB 연결 코드(JNDI 방식) */
	Context initCtx = new InitialContext();
	Context envCtx = (Context) initCtx.lookup("java:comp/env");

	DataSource ds = (DataSource) envCtx.lookup("dbcp_myoracle"); /* xml파일에 넣어줬던 긴 장문코드에 맞게 이름 수정 */

	Connection conn = ds.getConnection();
	
	if(conn != null){
		out.print("접속 성공");
	} else{
		out.print("접속 실패");
	}

/* 	conn.close(); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jdbcConnection</title>
</head>
<body>

</body>
</html>
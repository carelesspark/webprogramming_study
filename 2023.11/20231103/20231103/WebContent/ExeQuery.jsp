<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.JDBConnect"%>
<%@ page import="common.DBConnPool"%>
<%@ page import="java.sql.*"%>

<%
	// 저장되어 있는 값 select 해보기
	DBConnPool pool = new DBConnPool();

	String sql = "select * from member";
	
	Statement stmt = pool.con.createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	
	int count = 0;
	while(rs.next()){ // while문을 돌면서 레코드를 하나씩 가져온다
		String id = rs.getString("id");
		String pass = rs.getString("pass");
		String name = rs.getString("name");
		Date regidate = rs.getDate("regidate");
		
		count++;
		out.print(count + ". " + String.format("%s %s %s %s", id, pass, name, regidate) + "<br/>");
	}

	pool.close();
%>
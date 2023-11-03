<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="common.JDBConnect"%>
<%@ page import="common.DBConnPool"%>
<%@ page import="java.sql.*"%>
<%
	//JDBC에서의 필드 역할
	// Connection con : 데이터 베이스 접속
	// Statement stmt : CRUD 구문 실행하기 위한 역할
	// PreparedStatement psmt : CRUD 구문 실행하기 위한 역할(동적인 데이터를 사용하여 쿼리문 실행)
	// ResultSet rs : SELECT구문의 실행 결과를 받아주는 역할

	// executeQuery() : select
	// executeUpdate() : insert, update, delete

	DBConnPool pool = new DBConnPool();

	// 값 insert 방법 1
	 String sql = "insert into member values('aaa', '1234', 'park', sysdate)"; 
	
	 Statement stmt = pool.con.createStatement(); 
	
	 int result = stmt.executeUpdate(sql); 

	// 값 insert 방법 2
	/* String id = "bbb";
	String pass = "1111";
	String name = "박종혁";

	String sql = "insert into member values(?, ?, ?, sysdate)";

	PreparedStatement pstmt = pool.con.prepareStatement(sql); */

	// setInt, setFloat, setString, setDate......
	/* pstmt.setString(1, id);
	pstmt.setString(2, pass);
	pstmt.setString(3, name); */

	// 트랜잭션(commit, rollback)
	// auto commit	
	/* pool.con.setAutoCommit(false); // autocommit을 false로 함으로써 insert를 실행해도 값이 한번에 들어가지 않음

	int result = pstmt.executeUpdate();

	if (result != 0) {
		out.print(result + "행이 추가되었습니다.");
		pool.con.commit(); // pool.con.commit을 함으로써 값이 들어가게 됨
	} else {
		out.print("행 추가에 실패하였습니다.");
		pool.con.rollback();
	} */

	

	//////////////////////////////////////////////////////////////////////////////////////

	// 값 update 방법 
	/* String sql = "update member set pass = ?, name = ? where id = ?";
	PreparedStatement pstmt = pool.con.prepareStatement(sql);
	
	pstmt.setString(1, "0000");
	pstmt.setString(2, "HELLO");
	pstmt.setString(3, "aaa");
	
	int result = pstmt.executeUpdate(); */

	/* if (result != 0) {
		out.print("행이 변경되었습니다.");
	} else {
		out.print("행 변경에 실패하였습니다.");
	} */
	//////////////////////////////////////////////////////////////////////////////////////

	// 값 delete 방법

	/* String sql = "delete from member where id = ?";
	
	PreparedStatement pstmt = pool.con.prepareStatement(sql);
	
	pstmt.setString(1, "aaa");
	
	int result = pstmt.executeUpdate();
	
	
	if (result != 0) {
		out.print("행이 삭제되었습니다.");
	} else {
		out.print("행 삭제에 실패하였습니다.");
	} */

	pool.close();
%>
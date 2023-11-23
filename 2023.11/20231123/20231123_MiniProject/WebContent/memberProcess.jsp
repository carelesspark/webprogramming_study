<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="membership.JoinDAO"%>
<%@ page import="membership.JoinDTO"%>
<%@ page import="utils.JSFunction" %>
<%
	request.setCharacterEncoding("utf-8");

	String userId = request.getParameter("id");
	String userName = request.getParameter("name");
	String userEmail = request.getParameter("email");
	String userComment = request.getParameter("comment");
	
	System.out.print(userId);
	System.out.print(userName);
	System.out.print(userEmail);
	System.out.print(userComment);
	
	String driver = application.getInitParameter("OracleDriver");
	String url = application.getInitParameter("OracleUrl");
	String id = application.getInitParameter("OracleId");
	String pwd = application.getInitParameter("OraclePwd");
	
	JoinDAO dao = new JoinDAO(driver, url, id, pwd);
	JoinDTO dto = new JoinDTO();
	
	dto.setId(userId);
	dto.setName(userName);
	dto.setEmail(userEmail);
	dto.setComment(userComment);
	
	int result = dao.insertMember(dto);
	System.out.print(result);
	
	if(result > 0){
		JSFunction.alertLocation(response, "회원가입이 완료 되었습니다.", "main.jsp");
	} else{
		JSFunction.alertLocation(response, "에러가 발생했습니다!", "error.jsp");		
	}
%>
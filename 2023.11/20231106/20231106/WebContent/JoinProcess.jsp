<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="membership.MemberJoinDTO" %>
<%@ page import="membership.MemberDAO" %>
<% 
	String userId = request.getParameter("join_id");
	String userPwd = request.getParameter("join_pw");
	String adr1 = request.getParameter("join_adr1");
	String adr2 = request.getParameter("join_adr2");
	String gender = request.getParameter("join_gender");
	String[] hobbys = request.getParameterValues("join_hobby");
	String hys = "";
	for(String h : hobbys){
		hys += h + ",";
	}
	String phon1 = request.getParameter("join_phon1");
	String phon2 = request.getParameter("join_phon2");
	String phon3 = request.getParameter("join_phon3");
	String job = request.getParameter("join_job");
	String introduce = request.getParameter("join_introduce");
	
	
	String driver = application.getInitParameter("OracleDriver");
	String url = application.getInitParameter("OracleUrl");
	String id = application.getInitParameter("OracleId");
	String pwd = application.getInitParameter("OraclePwd");
	
	MemberDAO dao = new MemberDAO(driver, url, id, pwd);
	MemberJoinDTO dto = new MemberJoinDTO();
	dto.setJoin_id(userId);
	dto.setJoin_pw(userPwd);
	dto.setJoin_adr1(adr1);
	dto.setJoin_adr2(adr2);
	dto.setJoin_gender(gender);
	dto.setJoin_hobby(hys);
	dto.setJoin_phon1(phon1);
	dto.setJoin_phon2(phon2);
	dto.setJoin_phon3(phon3);
	dto.setJoin_job(job);
	dto.setJoin_introduce(introduce);
	
	int result = dao.insertMemberDTO(dto);
	
	if(result != 0){
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
	} else {
		response.sendRedirect("MemberJoin.jsp");
	}
	
	
	
%>
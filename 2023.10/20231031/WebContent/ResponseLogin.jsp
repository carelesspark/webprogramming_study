<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 단순 데이터 처리(response)를 하려면 html 코드가 따로 필요 없음 -->

<% 

	// response 객체
	// sendRedirect(페이지 경로) : 페이지를 이동한다.
	

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals("abc") && pw.equals("1234")){ // 로그인 성공
		response.sendRedirect("./ResponseWelcome.jsp");
	} else { // 로그인 실패
		// response.sendRedirect("./ResponseMain.jsp"); // 로그인에 실패해도 url이 바뀌지 않음
		request.getRequestDispatcher("ResponseMain.jsp?loginErr=1").forward(request, response); // 로그인 실패 시 url 바뀜
	}
%>

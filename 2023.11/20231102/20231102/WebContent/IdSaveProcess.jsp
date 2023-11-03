<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="utils.CookieManager"%>
<%@ page import="utils.JSFunction"%>
<%
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String save_check = request.getParameter("save_check");

	if ("must".equals(user_id) && "1234".equals(user_pw)) {
		// 로그인 성공
		if (save_check != null && save_check.equals("Y")) {
			System.out.print("로그인 성공");
			CookieManager.makeCookie(response, "loginId", user_id, 86400);
		} else {
			CookieManager.deleteCookie(response, "loginId");
		}

		//out.print("<script>alert('로그인성공'); location.href='IdSaveMain.jsp'</script>");
		JSFunction.alertLocation("로그인성공", "IdSaveMain.jsp", out);
	} else {
		// 로그인 실패
		//out.print("<script>alert('로그인실패'); history.back()</script>");
		JSFunction.alertBack("로그인실패", out);
	}

	//response.sendRedirect("./IdSaveMain.jsp");
%>
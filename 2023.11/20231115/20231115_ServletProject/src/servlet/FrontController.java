package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.one")
public class FrontController extends HttpServlet { // 서블릿은 요청을 받았을 때 요청을 판단하고 해당 조건에 맞게 요청을 수행하고 결과를 전송한다.

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		int lastSlash = uri.lastIndexOf("/"); // 가져온 URI의 마지막 "/"부분의 문자열 가져오기
		String commandString = uri.substring(lastSlash); // substring = 문자열 자르기

		if (commandString.equals("/regist.one")) {
			registFun(req);
		} else if (commandString.equals("/login.one")) {
			loginFun(req);
		} else if (commandString.equals("/freeboard.one")) {
			freeboardFun(req);
		}

		req.setAttribute("uri", uri);
		req.setAttribute("commandStr", commandString);

		req.getRequestDispatcher("./FrontController.jsp").forward(req, res);
	}

	void registFun(HttpServletRequest req) {
		req.setAttribute("resultValue", "<h4>회원가입</h4>");
	}

	void loginFun(HttpServletRequest req) {
		req.setAttribute("resultValue", "<h4>로그인</h4>");
	}

	void freeboardFun(HttpServletRequest req) {
		req.setAttribute("resultValue", "<h4>게시판</h4>");
	}

}

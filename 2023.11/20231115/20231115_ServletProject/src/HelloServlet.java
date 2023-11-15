import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. URL 요청을 통해서만 실행가능
// jsp 영역 객체
// page -> pageContext
// request -> HttpServletRequest
// response -> HttpServletResponse
// session -> HttpSession
// application -> ServletContext

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8"); // 한글 깨짐 방지

		PrintWriter out = res.getWriter();
		out.print("<h1>get방식의 Servlet 요청입니다.</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

}

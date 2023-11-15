
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet2") // 이 어노테이션를 사용할 경우 web.xml에 작성한 서블릿 매핑 코드를 작성할 필요가 없다.
public class HelloServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8"); // 한글 깨짐 방지

		PrintWriter out = res.getWriter();
		out.print("<h1>get방식의 Servlet2 요청입니다.</h1>");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

}

package model2.mvcboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fileupload.FileUtil;
import utils.JSFunction;

@WebServlet("/mvcboard/pass.do")
public class PassController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("mode", req.getParameter("mode"));
		req.getRequestDispatcher("../Pass.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html; charset=utf-8");

		String idx = req.getParameter("idx");
		String mode = req.getParameter("mode");
		String pass = req.getParameter("pass");

		MVCBoardDAO dao = new MVCBoardDAO();
		boolean confrimed = dao.confirmPassword(pass, idx);

		dao.close();

		if (confrimed == true) {
			if (mode.equals("edit")) {
				HttpSession session = req.getSession();
				session.setAttribute("pass", pass);
				res.sendRedirect("../mvcboard/edit.do?idx=" + idx);
			} else if (mode.equals("delete")) {
				dao = new MVCBoardDAO();
				MVCBoardDTO dto = dao.selectView(idx);
				int result = dao.deletePost(idx);
				dao.close();

				if (result > 0) {
					String saveFileName = dto.getSfile();
					FileUtil.deleteFile(req, "/Uploads", saveFileName);
					JSFunction.alertLocation(res, "삭제되었습니다.", "../mvcboard/list.do");
				} else {
					JSFunction.alertBack(res, "삭제에 실패하였습니다.");
				}
			}
		} else {
			JSFunction.alertBack(res, "비밀번호 검증 실패");
		}

	}

}

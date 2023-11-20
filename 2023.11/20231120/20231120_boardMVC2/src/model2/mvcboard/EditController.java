package model2.mvcboard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import fileupload.FileUtil;
import utils.JSFunction;

@WebServlet("/mvcboard/edit.do")
public class EditController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String idx = req.getParameter("idx");
		MVCBoardDAO dao = new MVCBoardDAO();
		MVCBoardDTO dto = dao.selectView(idx);

		req.setAttribute("dto", dto);
		req.getRequestDispatcher("../Edit.jsp").forward(req, res);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html; charset=utf-8"); 

		// 1. 파일 업로드 처리

		String saveDirectory = req.getServletContext().getRealPath("/Uploads");

		ServletContext application = getServletContext();

		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));

		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);

		if (mr == null) {
			JSFunction.alertLocation(res, "첨부파일이 제한 용량 초과", "../mvcboard/write.do");

			return;
		}

		// 2. 파일 이외의 정보 처리

		String idx = mr.getParameter("idx");
		String prevOfile = mr.getParameter("prevOfile");
		String prevSfile = mr.getParameter("prevSfile");
		String name = mr.getParameter("name");
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");

		HttpSession session = req.getSession();
		String pass = (String) session.getAttribute("pass");

		MVCBoardDTO dto = new MVCBoardDTO();
		dto.setIdx(idx);
		dto.setName(name);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setPass(pass);

		String fileName = mr.getFilesystemName("ofile");
		if (fileName != null) {
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String now = new SimpleDateFormat("yyyyMMdd_Hms").format(new Date());
			String newFileName = now + ext; // 20231114_121022.txt

			// 파일명 변경
			File oldFile = new File(saveDirectory + File.separator + fileName);
			File newFile = new File(saveDirectory + File.separator + newFileName);

			oldFile.renameTo(newFile);

			dto.setOfile(fileName);
			dto.setSfile(newFileName);

			FileUtil.deleteFile(req, "/Uploads", prevSfile);
		} else {
			dto.setOfile(prevOfile);
			dto.setSfile(prevSfile);
		}

		MVCBoardDAO dao = new MVCBoardDAO();
		int result = dao.updatePost(dto);

		if (result > 0) {
			session.removeAttribute("pass");
			res.sendRedirect("../mvcboard/view.do?idx=" + idx);
		} else {
			JSFunction.alertLocation(res, "비밀번호 검증을 다시 진행해 주세요", "../mvcboard/view.do?idx=" + idx);
		}
	}

}

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

import com.oreilly.servlet.MultipartRequest;

import fileupload.FileUtil;
import utils.JSFunction;

@WebServlet("/mvcboard/write.do")
public class WriteController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		// 글쓰기 폼 요청
		req.getRequestDispatcher("../Write.jsp").forward(req, res);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		// 글쓰기 데이터 저장
		
		// 1. 파일업로드 처리
		
		String saveDirectory = req.getServletContext().getRealPath("/Uploads");
		
		ServletContext application = getServletContext();
		
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		
		if(mr == null) {
			// out객체
			// JspWriter(jsp) -> PrintWriter(java)
			// PrintWriter out = response.getWriter();
			
			JSFunction.alertLocation(res, "첨부파일이 제한 용량 초과", "../mvcboard/write.do");
			
			return;
		}
		
		MVCBoardDTO dto = new MVCBoardDTO();
		dto.setName(mr.getParameter("name"));
		dto.setTitle(mr.getParameter("title"));
		dto.setContent(mr.getParameter("content"));
		dto.setPass(mr.getParameter("pass"));
		
		String fileName = mr.getFilesystemName("ofile");
		
		if(fileName != null) {
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String now = new SimpleDateFormat("yyyyMMdd_Hms").format(new Date());
			String newFileName = now + ext; // 20231114_121022.txt
			
			// 파일명 변경
			File oldFile = new File(saveDirectory + File.separator + fileName);
			File newFile = new File(saveDirectory + File.separator + newFileName);
			
			oldFile.renameTo(newFile);
			
			dto.setOfile(fileName);
			dto.setSfile(newFileName);
		}
		
		MVCBoardDAO dao = new MVCBoardDAO();
		int result = dao.inserWrite(dto);
		
		if(result > 0) {
			res.sendRedirect("../mvcboard/list.do");
		} else {
			res.sendRedirect("../mvcboard/wirte.do");		
		}
		
	}

}

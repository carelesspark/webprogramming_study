package model2.mvcboard;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.BoardPage;

@WebServlet("/mvcboard/list.do")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		MVCBoardDAO dao = new MVCBoardDAO();

		Map<String, Object> params = new HashMap<>();

		String searchField = req.getParameter("searchField");
		String searchWord = req.getParameter("searchWord");

		if (searchWord != null) {
			params.put("searchField", searchField);
			params.put("searchWord", searchWord);
		}

		int totalCount = dao.selectCount(params);

		// 페이지 처리
		ServletContext application = this.getServletContext(); // 서블릿 내에서의 application 사용 방식
		int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
		int blockPage = Integer.parseInt(application.getInitParameter("POSTS_PER_BLOCK"));

		// 현재 페이지 확인
		int pageNum = 1;
		String pageTemp = req.getParameter("pageNum");
		if (pageTemp != null && !pageTemp.equals("")) {
			pageNum = Integer.parseInt(pageTemp);
		}

		// 목록에 출력할 게시물 범위 계산
		int start = (pageNum - 1) * pageSize + 1;
		int end = (pageNum * pageSize);

		params.put("start", start);
		params.put("end", end);

		List<MVCBoardDTO> boardLists = dao.selectListPage(params);

		dao.close();

		String pageString = BoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, "/mvcboard/list.do");

		params.put("pageString", pageString);
		params.put("totalCount", totalCount);
		params.put("pageSize", pageSize);
		params.put("pageNum", pageNum);

		req.setAttribute("boardLists", boardLists);
		req.setAttribute("params", params);

		req.getRequestDispatcher("/List.jsp").forward(req, res); // "/" 슬래쉬 붙이기

	}

}

package com.spring.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.practice.board.BoardVO;
import com.spring.practice.board.impl.BoardDAO;
import com.spring.practice.user.UserVO;
import com.spring.practice.user.impl.UserDAO;

// @WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res); // get, post를 한번에 process에서
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); 
		process(req, res); // get, post를 한번에 process에서
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 프론트 컨트롤러
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
	
		if(path.equals("/login.do")) { // 로그인 처리
			System.out.println("로그인 처리");
			
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO dao = new UserDAO();
			UserVO user = dao.getUser(vo);
			
			if(user != null) {
				res.sendRedirect("./getBoardList.do");
			} else {
				res.sendRedirect("./login.jsp");
			}
		} else if(path.equals("/logout.do")) { // 로그아웃 처리
			System.out.println("로그아웃 처리");	
			
			HttpSession session = req.getSession();
			session.invalidate();
			
			res.sendRedirect("./login.jsp");
			
		} else if(path.equals("/insertBoard.do")){ // 글 등록 처리
			System.out.println("글 등록 처리");	
			
			req.setCharacterEncoding("utf-8");
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");
			
			BoardVO vo = new BoardVO();
			BoardDAO dao = new BoardDAO();
			
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			dao.insertBoard(vo);
			
			res.sendRedirect("./getBoardList.do");
			
		} else if(path.equals("/updateBoard.do")) { // 글 수정 처리
			System.out.println("글 수정 처리");	
			
			req.setCharacterEncoding("utf-8");
			String seq = req.getParameter("seq");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			BoardVO vo = new BoardVO();
			BoardDAO dao = new BoardDAO();
			
			vo.setSeq(Integer.parseInt(seq));
			vo.setTitle(title);
			vo.setContent(content);
			
			dao.updateBoard(vo);
			
			res.sendRedirect("./getBoardList.do");
			
		} else if(path.equals("/deleteBoard.do")) { // 글 삭제 처리
			System.out.println("글 삭제 처리");
			
			String seq = req.getParameter("seq");
			
			BoardVO vo = new BoardVO();
			BoardDAO dao = new BoardDAO();
			
			vo.setSeq(Integer.parseInt(seq));
			
			dao.deleteBoard(vo);
			
			res.sendRedirect("./getBoardList.do");
		} else if(path.equals("/getBoard.do")) { // 글 상세 조회 처리
			System.out.println("글 상세 조회 처리");
			
			String seq = req.getParameter("seq");
			
			BoardVO vo = new BoardVO();
			BoardDAO dao = new BoardDAO();
			
			vo.setSeq(Integer.parseInt(seq));
			BoardVO userBoard = dao.getBoard(vo);
			
			HttpSession session = req.getSession();
			session.setAttribute("userBoard", userBoard);
			
			res.sendRedirect("./getBoard.jsp");
					
		} else if(path.equals("/getBoardList.do")) {// 글 목록 검색 처리
			System.out.println("글 목록 검색 처리");
			
			BoardVO vo = new BoardVO();
			BoardDAO dao = new BoardDAO();
			List<BoardVO> boardList = dao.getBoardList();
			
			HttpSession session = req.getSession();
			session.setAttribute("boardList", boardList);
			// boardList를 서버에 보내주려면 위 처럼 session에 boardList를 저장하거나, 밑의 sendRedirect를 forward방식으로 변경하거나 해야함
			res.sendRedirect("./getBoardList.jsp");
		}
	}
}

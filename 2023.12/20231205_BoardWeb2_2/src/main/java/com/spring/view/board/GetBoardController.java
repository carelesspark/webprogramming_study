package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.practice.board.BoardVO;
import com.spring.practice.board.impl.BoardDAO;

@Controller
public class GetBoardController {

	@RequestMapping(value = "/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO dao, ModelAndView mav) throws Exception {
//
		System.out.println("글 상세 조회 처리");
//		String seq = request.getParameter("seq");
//
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//		BoardDAO dao = new BoardDAO();
//		BoardVO board = dao.getBoard(vo);

//		HttpSession session = request.getSession();
//		session.setAttribute("board", board);
//		response.sendRedirect("./getBoard.jsp");

		BoardVO board = dao.getBoard(vo);
		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");

		return mav;
	}

}
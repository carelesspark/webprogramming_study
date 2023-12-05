package com.spring.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.practice.board.BoardVO;
import com.spring.practice.board.impl.BoardDAO;

@Controller
public class GetBoardListController{

	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO dao, ModelAndView mav) throws Exception {
		
		System.out.println("글 목록 검색 처리");
		
//		BoardVO vo = new BoardVO();
//		BoardDAO dao = new BoardDAO();
//		List<BoardVO> boardList = dao.getBoardList();
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
//		response.sendRedirect("./getBoardList.jsp");
		
//		ModelAndView mav = new ModelAndView();
		List<BoardVO> boardList = dao.getBoardList();
		mav.addObject("boardList",boardList);
		mav.setViewName("getBoardList.jsp");
		
		return mav;
	}

}

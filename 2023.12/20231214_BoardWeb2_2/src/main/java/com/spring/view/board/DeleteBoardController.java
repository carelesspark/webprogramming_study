package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.practice.board.BoardVO;
import com.spring.practice.board.impl.BoardDAO;

//@Controller
public class DeleteBoardController  {

	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO dao) throws Exception {

		System.out.println("글 삭제 처리");
//		
//		String seq = request.getParameter("seq");
//		
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//		
//		BoardDAO dao = new BoardDAO();
//		dao.deleteBoard(vo);
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("getBoardList.do");
		
		
		dao.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}

}

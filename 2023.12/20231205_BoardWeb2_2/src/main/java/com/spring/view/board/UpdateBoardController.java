package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.spring.practice.board.BoardVO;
import com.spring.practice.board.impl.BoardDAO;


@Controller
public class UpdateBoardController  {

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO dao) throws Exception {
		
		System.out.println("글 수정 처리");
		
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String seq = request.getParameter("seq");
		
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setSeq(Integer.parseInt(seq));
//		
//		BoardDAO dao = new BoardDAO();
//		dao.updateBoard(vo);
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("getBoardList.do");
		
		dao.updateBoard(vo);
		
		return "redirect:getBoardList.do"; 
	}

}

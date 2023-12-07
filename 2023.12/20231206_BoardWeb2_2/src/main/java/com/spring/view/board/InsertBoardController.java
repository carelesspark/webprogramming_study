package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.spring.practice.board.BoardVO;
import com.spring.practice.board.impl.BoardDAO;

//@Controller
public class InsertBoardController{

		@RequestMapping(value="/insertBoard.do")
		public String insertBoard(BoardVO vo, BoardDAO boardDAO) { // 스프링 컨테이너가 컨트롤러가 구성되어 있는 클래스가 RequestMapping을 받고있는 이 객체를 알아서 값을 넣어줌
	
		System.out.println("글 등록 처리");
		
		/*
		 * String title = request.getParameter("title"); String writer =
		 * request.getParameter("writer"); String content =
		 * request.getParameter("content");
		 * 
		 * BoardVO vo = new BoardVO(); vo.setTitle(title); vo.setWriter(writer);
		 * vo.setContent(content);
		 */
		
		/* BoardDAO boardDAO = new BoardDAO(); */
		boardDAO.insertBoard(vo);
		
		return "redirect:getBoardList.do"; // forward방식 이동
		
	}

}

package com.spring.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.practice.board.BoardVO;
import com.spring.practice.board.impl.BoardDAO;

@Controller
public class BoardController { // 통합 컨트롤러
	// 글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) { // 스프링 컨테이너가 컨트롤러가 구성되어 있는 클래스가 RequestMapping을 받고있는 이
																// 객체를 알아서 값을 넣어줌

		System.out.println("글 등록 처리");

		boardDAO.insertBoard(vo);

		return "redirect:getBoardList.do"; // forward방식 이동

	}

	// 글 수정

	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO dao) throws Exception {

		System.out.println("글 수정 처리");

		dao.updateBoard(vo);

		return "redirect:getBoardList.do";
	}

	// 글 삭제

	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO dao) throws Exception {

		System.out.println("글 삭제 처리");
		
		dao.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO dao, Model model) throws Exception {

		System.out.println("글 상세 조회 처리");


		BoardVO board = dao.getBoard(vo);
		model.addAttribute("board", board);

		return "getBoard.jsp";
	}
	

	// 글 목록 검색
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO dao, Model model) throws Exception {
		
		System.out.println("글 목록 검색 처리");
		List<BoardVO> boardList = dao.getBoardList();
		model.addAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}

}

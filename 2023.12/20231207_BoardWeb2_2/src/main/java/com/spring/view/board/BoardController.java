package com.spring.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.practice.board.BoardVO;
import com.spring.practice.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController { // 통합 컨트롤러
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap") // @RequestMapping이 적용된 메소드보다 @ModelAttribute가 적용된 메소드가 먼저 실행
	public Map<String, String> searchConditionMap(){
		
		Map<String, String> conditionMap = new HashMap();
		
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("작성자", "WRITER");
		
		return conditionMap;
		
	}
	
	
	
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
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO dao) throws Exception {
		// 위 처럼 BoardVO 커맨드 객체 앞에 @ModelAttribute("board")를 붙이는 의미는 뷰 페이지에서 해당 커맨드 객체를 사용할 때
		// "board"라고 사용자 정의한 이름을 사용하기 위해서임 - 이를 위해선 위에 @SessionAttributes("board")와 같이 사용해야 함
		System.out.println("글 수정 처리");

		System.out.println("작성자 : " + vo.getWriter());
		System.out.println("날짜 : "  + vo.getRegDate());
		System.out.println("제목 : "  + vo.getTitle());
		System.out.println("내용 : "  + vo.getContent());
		
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
	

	/*
	 * // 글 목록 검색 - 이전 버전
	 * 
	 * @RequestMapping(value="/getBoardList.do") public String
	 * getBoardList( @RequestParam(value="searchCondition", defaultValue = "TITLE",
	 * required=false) String condition,
	 * 
	 * @RequestParam(value="searchKeyword", defaultValue = "", required=false)
	 * String keyword, BoardVO vo, BoardDAO dao, Model model) throws Exception {
	 * 
	 * System.out.println("검색 조건 : " + condition); System.out.println("설명 조건 : " +
	 * keyword);
	 * 
	 * System.out.println("글 목록 검색 처리"); List<BoardVO> boardList =
	 * dao.getBoardList(); model.addAttribute("boardList", boardList);
	 * 
	 * return "getBoardList.jsp"; }
	 */
	
	// 글 목록 검색
	
		@RequestMapping(value="/getBoardList.do")
		public String getBoardList(BoardVO vo, BoardDAO dao, Model model) throws Exception {
			
			System.out.println("검색 조건 : " + vo.getSearchCondition());
			System.out.println("설명 조건 : " + vo.getSearchKeyword());
			
			System.out.println("글 목록 검색 처리");
			List<BoardVO> boardList = dao.getBoardList();
			model.addAttribute("boardList", boardList);
			
			return "getBoardList.jsp";
		}

}

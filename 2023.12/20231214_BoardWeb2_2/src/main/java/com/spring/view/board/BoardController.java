package com.spring.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.practice.board.BoardService;
import com.spring.practice.board.BoardVO;
import com.spring.practice.board.impl.BoardDAO;
import com.spring.practice.board.impl.BoardServiceImpl;

@Controller
@SessionAttributes("board")
public class BoardController { // 통합 컨트롤러
	
	
	@Autowired
	private BoardService boardService; // 기존에 안 사용한 서비스 형식을 사용하기 위해 @Autowired와 BoardService객체 생성
										// 그렇게 기존에 사욯하던 dao를 삭제하고 boardService로 메소드 사용
										// 그 후 test폴더에 있는 BoardServiceClient로 감
										// 동작 방향 Servlet container -> Spring Container
										// Spring Container(안에는 Controller -> Service -> DAO) 사용
	
									  // Servlet container -> Spring Container  
									  // Spring Container(안에는 Controller -> Service -> DAO) 
									  // service를 사용하더니 index.jsp가 안열림 -> web.xml에 가서 <context-param> + <listener>사용
	 
	
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap") // @RequestMapping이 적용된 메소드보다 @ModelAttribute가 적용된 메소드가 먼저 실행
	public Map<String, String> searchConditionMap(){
		
		Map<String, String> conditionMap = new HashMap();
		
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("작성자", "WRITER");
		
		return conditionMap;
		
	}
	
	// json 처리
	@RequestMapping(value="/dataTransform.do")
	@ResponseBody // json형식의 데이터를 리턴하기 위해 사용된다.
	public List<BoardVO> dataTransform(BoardVO vo){
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		
		return boardList;
	}
	
	
	
	// 글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException { // 스프링 컨테이너가 컨트롤러가 구성되어 있는 클래스가 RequestMapping을 받고있는 이
																// 객체를 알아서 값을 넣어줌

		System.out.println("글 등록 처리");
		
		MultipartFile uploadFile = vo.getUploadFile();
		
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C://upload/" + fileName));
		}

		boardService.insertBoard(vo);

		return "redirect:getBoardList.do"; // forward방식 이동

	}

	// 글 수정

	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) throws Exception {
		// 위 처럼 BoardVO 커맨드 객체 앞에 @ModelAttribute("board")를 붙이는 의미는 뷰 페이지에서 해당 커맨드 객체를 사용할 때
		// "board"라고 사용자 정의한 이름을 사용하기 위해서임 - 이를 위해선 위에 @SessionAttributes("board")와 같이 사용해야 함
		System.out.println("글 수정 처리");

		System.out.println("작성자 : " + vo.getWriter());
		System.out.println("날짜 : "  + vo.getRegDate());
		System.out.println("제목 : "  + vo.getTitle());
		System.out.println("내용 : "  + vo.getContent());
		
		boardService.updateBoard(vo);

		return "redirect:getBoardList.do";
	}

	// 글 삭제

	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo) throws Exception {

		System.out.println("글 삭제 처리");
		
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardVO vo, Model model) throws Exception {

		System.out.println("글 상세 조회 처리");

		BoardVO board = boardService.getBoard(vo);
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
		public String getBoardList(BoardVO vo, Model model) throws Exception {


			if(vo.getSearchCondition() == null) {
				vo.setSearchCondition("TITLE");
			}
			
			if(vo.getSearchKeyword() == null) {
				vo.setSearchKeyword("");
			}
			
			System.out.println("글 목록 검색 처리");
			List<BoardVO> boardList = boardService.getBoardList(vo);
			model.addAttribute("boardList", boardList);
			
			return "getBoardList.jsp";
		}

}

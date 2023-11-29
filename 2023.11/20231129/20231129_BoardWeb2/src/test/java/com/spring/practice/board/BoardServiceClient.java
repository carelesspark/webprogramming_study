package com.spring.practice.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) factory.getBean("boardService");

//		insert 부분

		/*
		 * BoardVO vo = new BoardVO(); vo.setTitle("임시 제목"); vo.setWriter("임시 작성자");
		 * vo.setContent("임시 내용...");
		 * 
		 * boardService.insertBoard(vo);
		 */

//		update 부분

		/*
		 * BoardVO vo = new BoardVO(); vo.setSeq(6); vo.setTitle("SpringJdbc 제목 수정");
		 * vo.setContent("SpringJdbc 본문 수정"); boardService.updateBoard(vo);
		 */

//		delete 부분

		/*
		 * BoardVO vo = new BoardVO(); vo.setSeq(6); boardService.deleteBoard(vo);
		 */

//		get board 부분

		/*
		 * BoardVO vo = new BoardVO(); vo.setSeq(2); BoardVO board =
		 * boardService.getBoard(vo); System.out.println(board);
		 */

//		board 정렬

		List<BoardVO> boardLists = boardService.getBoardList();
		for (BoardVO board : boardLists) {
			System.out.println(board);
		}

	}
}

package com.spring.practice.board;

import java.util.List;


public interface BoardService {
	// 서비스 계층 생성
	// CRUD 기능의 메소드 구현
	// 글 등록
	
	void insertBoard(BoardVO vo);
	
	// 글 수정
	void updateBoard(BoardVO vo);
	
	// 글 삭제
	void deleteBoard(BoardVO vo);
	
	// 글 상세  조회
	BoardVO getBoard(BoardVO vo);
	
	
	// 글 목록 조회
	List<BoardVO> getBoardList();
	
}

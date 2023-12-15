package com.spring.practice.board.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.practice.board.BoardVO;
import com.spring.practice.common.JDBCUtil;

@Repository
public class BoardDAOSpring {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content)"
			+ " values((select nvl(max(seq),0)+1 from board), ?, ?, ?)";

	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	
	private final String BOARD_DELETE = "delete from board where seq = ?";
	
	private final String BOARD_GET = "select * from board where seq = ?";
	
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	// CRUD 기능의 메소드 구현
		// 글 등록
		public void insertBoard(BoardVO vo) {
			System.out.println("===> SpringJDBC로 insertBoard() 기능 처리");
			jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());

		}

		// 글 수정
		public void updateBoard(BoardVO vo) {
			System.out.println("===> SpringJDBC로 updateBoard() 기능 처리");
			jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
			
		}

		// 글 삭제
		public void deleteBoard(BoardVO vo) {
			System.out.println("===> SpringJDBC로 deleteBoard() 기능 처리");
			jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
			
		}

		// 글 상세 조회
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("==> SpringJDBC로 getBoard() 기능 처리");
			Object[] args = {vo.getSeq()}; // int을 그냥 못써서 Object형식으로 변환 해주어야 함
			return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper()); 
		}

		// 글 목록 조회
		public List<BoardVO> getBoardList(){
			List<BoardVO> boardList = new ArrayList();
			System.out.println("==> SpringJDBC로 getBoardList() 기능 처리");
			
			return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		}
}

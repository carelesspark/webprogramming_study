package com.spring.practice.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.practice.board.BoardVO;
import com.spring.practice.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String BOARD_INSERT = "insert into board(seq, title, writer, content)"
			+ " values((select nvl(max(seq),0)+1 from board), ?, ?, ?)";

	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	
	private final String BOARD_GET = "select * from board where seq = ?";
	
	private final String BOARD_LIST = "select * from board order by seq desc";

	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");

		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 글 삭제

	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("==> JDBC로 getBoard() 기능 처리");

		BoardVO board = null;

		conn = JDBCUtil.getConnection();

		try {
			conn.setAutoCommit(true);
			stmt = conn.prepareStatement(BOARD_GET);

			stmt.setInt(1, vo.getSeq());
			
			rs = stmt.executeQuery();

			if (rs.next()) {
				board = new BoardVO();

				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getDate("regDate"));
				board.setCnt(rs.getInt("cnt"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return board;
	}

	// 글 목록 조회
	public List<BoardVO> getBoardList(){
		List<BoardVO> boardList = new ArrayList();
		
		conn = JDBCUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(BOARD_LIST);

			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regDate"));
				board.setCnt(rs.getInt("cnt"));
				
				boardList.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return boardList;
	}

}

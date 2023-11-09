package model1.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

import javax.servlet.ServletContext;

import common.JDBConnect;

public class BoardDAO extends JDBConnect {

	public BoardDAO(ServletContext application) {
		super(application);
	}

	// 검색 조건에 맞는 게시물의 갯수 반환
	public int selectCount(Map<String, Object> map) {

		int totalCount = 0;

		String query = "select count(*) from board";
		if (map.get("searchWord") != null) {
			query += " where " + map.get("searchField") + " " + " like '%" + map.get("searchWord") + "%'";
		}

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			if (rs.next()) {
				totalCount = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return totalCount;
	}

	// 검색 조건에 맞는 게시물 목록 반환
	public List<BoardDTO> selectList(Map<String, Object> map) {

		// 1. 조회된 결과물을 저장할 변수 필요
		List<BoardDTO> list = new ArrayList<>();

		// 2. 쿼리문을 작성해서 변수에 저장
		String query = "select * from board";
		if (map.get("searchWord") != null) {
			query += " where " + map.get("searchField") + " " + " like '%" + map.get("searchWord") + "%'";
		}

		query += " order by num desc";

		try {
			// 3. connect 객체 생성
			// 4. 쿼리문 실행을 위한 객체를 생성
			stmt = con.createStatement();

			// 5. 쿼리문 실행하고 ResultSet객체에 저장
			rs = stmt.executeQuery(query);

			// 6. 결과를 변수에 저장 (BoardDTO사용해서 저장)
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();

				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public int insertWrite(BoardDTO dto) {

		int result = 0;

		String query = "insert into board (num, title, content, id, visitcount) values (seq_board_num.nextval, ?, ?, ?, 0)";

		try {
			psmt = con.prepareStatement(query);

			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());

			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public void updateVisitCount(String num) {
		String query = "update board set visitcount = visitcount + 1 where num = ?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);

			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public BoardDTO selectView(String num) {

		BoardDTO dto = new BoardDTO();

		// b.* = board 테이블의 모든 속성 정보 가져오기
		String query = "select b.*, m.name from member m inner join board b on m.id = b.id where num = ?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);

			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));
				dto.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

	public int updateEdit(BoardDTO dto) {
		int result = 0;

		String query = "update board set title = ?, content = ? where num = ?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNum());

			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int deletePost(BoardDTO dto) {
		int delete = 0;

		String query = "delete from board where num = ?";

		try {
			psmt = con.prepareStatement(query);

			psmt.setString(1, dto.getNum());
			delete = psmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return delete;
	}
}

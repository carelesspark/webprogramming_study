package model2.mvcboard;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.DBConnPool;
import model2.mvcboard.MVCBoardDTO;

public class MVCBoardDAO extends DBConnPool {

	// 검색 조건에 맞는 게시물의 개수를 반환
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0; // 결과(게시물 수)를 담을 변수

		String query = "select count(*) from mvcboard";
		if (map.get("searchWord") != null) {
			query += " where " + map.get("searchField") + " " + " like '%" + map.get("searchWord") + "%'";
		}

		try {
			stmt = con.createStatement(); // 쿼리문 실행
			rs = stmt.executeQuery(query); // 쿼리 실행

			if (rs.next()) { // 커서를 첫 번째 행으로 이동
				totalCount = rs.getInt(1); // 첫 번째 칼럼 값을 가져옴
			}

		} catch (SQLException e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}

		return totalCount;

	}

	// 검색 조건에 맞는 게시물 목록을 반환(페이징o)
	public List<MVCBoardDTO> selectListPage(Map<String, Object> map) {
		List<MVCBoardDTO> list = new ArrayList<>();

		String query = "select * from (select rownum rnum, tb.* from(select * from mvcboard";
		if (map.get("searchWord") != null) {
			query += " where " + map.get("searchField") + " " + " like '%" + map.get("searchWord") + "%'";
		}
		query += " order by idx desc) tb) where rnum between ? and ?";

		try {
			psmt = con.prepareStatement(query);

			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());

			rs = psmt.executeQuery();

			while (rs.next()) {
				MVCBoardDTO dto = new MVCBoardDTO();

				dto.setIdx(rs.getString("idx"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setOfile(rs.getString("ofile"));
				dto.setSfile(rs.getString("sfile"));
				dto.setDowncount(rs.getInt("downcount"));
				dto.setPass(rs.getString("pass"));
				dto.setVisitcount(rs.getInt("visitcount"));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 게시글 데이터를 받아 DB에 추가(파일 업로드 지원)
	public int inserWrite(MVCBoardDTO dto) {

		int result = 0;

		String query = "insert into mvcboard ( idx, name, title, content, ofile, sfile, pass) values (seq_board_num.nextval, ?, ?, ?, ?, ?, ?)";

		try {
			psmt = con.prepareStatement(query);

			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			psmt.setString(6, dto.getPass());

			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 주어진 일련번호에 해당하는 게시물을 DTO에 담아 반환
	public MVCBoardDTO selectView(String idx) {
		MVCBoardDTO dto = new MVCBoardDTO();

		String query = "select * from mvcboard where idx = ?";

		try {
			psmt = con.prepareStatement(query);

			psmt.setString(1, idx);

			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setIdx(rs.getString("idx"));
				dto.setName(rs.getString("name"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setVisitcount(rs.getInt("visitcount"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setOfile(rs.getString("ofile"));
				dto.setDowncount(rs.getInt("downcount"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return dto;
	}

	// 주어진 일련번호에 해당하는 게시물의 조회수를 1 증가
	public void updateVisitCount(String idx) {
		String query = "update mvcboard set visitcount = visitcount  + 1 where idx = ?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);

			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 입력한 비밀번호가 저장한 일련번호의 게시물의 비밀번호와 일치하는지 확인
	public boolean confirmPassword(String pass, String idx) {

		boolean isCorr = true;

		String query = "select count(*) from mvcboard where pass = ? and idx = ?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, pass);
			psmt.setString(2, idx);

			rs = psmt.executeQuery();

			rs.next();

			if (rs.getInt(1) == 0) {
				isCorr = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isCorr;
	}

	// 게시글 데이터를 받아 DB에 저장되어 있던 내용 갱신(파일 업로드 지원)
	public int updatePost(MVCBoardDTO dto) {
		int result = 0;

		String query = "update mvcboard set title = ?, name = ?, content = ?, ofile = ?, sfile = ? where idx = ? and pass = ?";

		try {
			psmt = con.prepareStatement(query);

			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			psmt.setString(6, dto.getIdx());
			psmt.setString(7, dto.getPass());

			result = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}

	// 게시글 삭제
	public int deletePost(String idx) {
		int result = 0;

		String query = "delete from mvcboard where idx = ?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);

			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return result;
	}
}

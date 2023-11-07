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
	public int selectCount() {

		return 0;
	}

	// 검색 조건에 맞는 게시물 목록 반환
	public List<BoardDTO> selectList(Map<String, Object> map) {

		// 1. 조회된 결과물을 저장할 변수 필요
		List<BoardDTO> list = new ArrayList<>();

		// 2. 쿼리문을 작성해서 변수에 저장
		String query = "select * from board";			
		if(map.get("searchWord") != null) {
			query += " where " + map.get("searchField") + " " + " like '%" + map.get("searchWord") + "%'";
		}
		
		System.out.println(query);
		
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

		// 7. 연결 종료
		close();
		
		return list;
		
		

	}

}

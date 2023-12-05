package com.spring.practice.user.impl;

import java.sql.*;

import org.springframework.stereotype.Repository;

import com.spring.practice.common.JDBCUtil;
import com.spring.practice.user.UserVO;

@Repository("userDAO")

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String USER_GET = "select * from users where id = ? and password = ?";
	
	// CRUD 기능의 메소드 구현
	// 회원 조회
	
	public UserVO getUser(UserVO vo) {
		
		System.out.println("====> getUser메소드 실행");
		
		UserVO user = null;
		
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_GET);
			
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
}

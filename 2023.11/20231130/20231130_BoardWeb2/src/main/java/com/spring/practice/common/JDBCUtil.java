package com.spring.practice.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pwd = "tiger";

			return DriverManager.getConnection(url, id, pwd);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void close(PreparedStatement stmt, Connection conn) {
		if (stmt != null) {
			try {
				if (!stmt.isClosed()) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
		if (conn != null) {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if (stmt != null) {
			try {
				if (!stmt.isClosed()) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
		if (conn != null) {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
		if (rs != null) {
			try {
				if (!rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
	}
}

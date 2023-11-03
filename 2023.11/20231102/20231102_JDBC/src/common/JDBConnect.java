package common;

import javax.servlet.ServletContext;
import javax.sql.*;
import java.sql.*;

public class JDBConnect {

	// DB접속 및 쿼리문 실행에 필요한 필수 객체
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;

	// 방법 1
	public JDBConnect() { 

		try {
			Class.forName("oracle.jdbc.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "musthave";
			String pwd = "1234";

			con = DriverManager.getConnection(url, id, pwd);

			System.out.println("DB 연결 성공(기본 생성자)");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 방법 2
	public JDBConnect(String driver, String url, String id, String pwd) { 

		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, id, pwd);

			System.out.println("DB 연결 성공(인수 생성자1)");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 방법 3
	public JDBConnect(ServletContext application) {

		try {
			String driver = application.getInitParameter("OracleDriver");
			Class.forName(driver);

			String url = application.getInitParameter("OracleUrl");
			String id = application.getInitParameter("OracleId");
			String pwd = application.getInitParameter("OraclePwd");

			con = DriverManager.getConnection(url, id, pwd);

			System.out.println("DB 연결 성공(인수 생성자2)");
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 반드시 연결하고 close해야 함, 계속 open상태일 경우 충돌 문제 발생 가능성
	public void close() {

		try {
			if (rs != null) // rs가 가장 먼저 닫혀야 되고,
				rs.close();
			if (stmt != null)
				stmt.close();
			if (psmt != null)
				psmt.close();
			if (con != null) // con이 가장 늦게 닫혀야 된다.
				con.close();
			
			System.out.println("JDBC 자원 해제");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

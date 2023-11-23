package membership;

import java.sql.SQLException;

import javax.servlet.ServletContext;

import common.JDBConnect;

public class JoinDAO extends JDBConnect{

	public JoinDAO(String driver, String url, String id, String pwd) {
		super(driver, url, id, pwd);
	}
	
	public int insertMember(JoinDTO dto) {
		
		int result = 0;
		String query = "insert into pagejoin values(seq_num_plus.nextval, ?, ?, ?, ?, sysdate)";
		
		try {
			psmt = con.prepareStatement(query);
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getEmail());
			psmt.setString(4, dto.getComment());
			
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}

package membership;

import java.sql.SQLException;

import common.JDBConnect;

public class MemberDAO extends JDBConnect {
	public MemberDAO(String driver, String url, String id, String pwd) {
		super(driver, url, id, pwd);
	}

	public MemberDTO getMemberDTO(String uid, String upass) {

		MemberDTO dto = new MemberDTO();
		String sql = "select * from member where id = ? and pass = ?";

		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, uid);
			psmt.setString(2, upass);

			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setRegidate(rs.getString("regidate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return dto;
	}

}

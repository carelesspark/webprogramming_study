package membership;

import java.sql.SQLException;

import common.JDBConnect;

public class MemberDAO extends JDBConnect{
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
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setRegidate(rs.getString("regidate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		
		return dto;
	}
	
	public int insertMemberDTO(MemberJoinDTO mem) {	
		int result = 0;
		
		String sql = "insert into memberJoin values(mem_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, mem.getJoin_id());
			psmt.setString(2, mem.getJoin_pw());
			psmt.setString(3, mem.getJoin_adr1());
			psmt.setString(4, mem.getJoin_adr2());
			psmt.setString(5, mem.getJoin_gender());	
			psmt.setString(6, mem.getJoin_hobby());
			psmt.setString(7, mem.getJoin_phon1());
			psmt.setString(8, mem.getJoin_phon2());
			psmt.setString(9, mem.getJoin_phon3());
			psmt.setString(10, mem.getJoin_job());
			psmt.setString(11, mem.getJoin_introduce());
			
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		
		return result; // result값이 0일 경우 값이 제대로 insert 되지 않았고, 그렇지 않다면 정상적으로 insert
	}
}

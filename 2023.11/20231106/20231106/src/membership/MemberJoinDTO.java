package membership;

import lombok.Data;

@Data
public class MemberJoinDTO {
	private String join_id;
	private String join_pw;
	private String join_adr1;
	private String join_adr2;
	private String join_gender;
	private String join_hobby;
	private String join_phon1;
	private String join_phon2;
	private String join_phon3;
	private String join_job;
	private String join_introduce;
}

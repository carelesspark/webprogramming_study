package membership;

import lombok.Data;

@Data
public class JoinDTO {
	private String id;
	private String name;
	private String email;
	private String comment;
}

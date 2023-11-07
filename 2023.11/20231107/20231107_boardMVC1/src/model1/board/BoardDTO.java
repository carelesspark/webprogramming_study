package model1.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDTO {
	private String num;
	private String title;
	private String content;
	private Date postdate;
	private String id;
	private String visitcount;
	private String name;
}

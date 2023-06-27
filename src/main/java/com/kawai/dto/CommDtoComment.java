package com.kawai.dto;

import lombok.Data;

@Data
public class CommDtoComment {
	private int comment_id;
	private String comment;
	private String comment_date;
	private int comment_group;
	private int comment_step;
	private int comment_indent;
	private String user_id;
	private String comment_ip;
	private int community_id;
	private int commentLikeCnt;
}

package com.kawai.dto;

import java.util.List;

import lombok.Data;

@Data
public class CommDto {
	private int community_id;
	private String community_title;
	private String community_content;
	private int community_hit;
	private String community_ip;
	private String community_date;
	private String user_id;
	private String user_name;
	private CommDtoBookinfo bookinfo;
	private CommDtoCategory commcategory;
	private int communityLikeCnt;
	private List<CommDtoComment> comment;
	private int community_hide;
}

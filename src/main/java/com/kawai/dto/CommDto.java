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
	private int comm_category_id;
	private String category_name;
	private int communityLikeCnt;
	private CommDtoCommunityLike like;
	private List<CommDtoComment> comment;
	private int community_hide;
}

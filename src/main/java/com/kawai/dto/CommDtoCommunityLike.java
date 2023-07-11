package com.kawai.dto;

import lombok.Data;

@Data
public class CommDtoCommunityLike {
	private int community_id;
	private String user_id;
	private boolean checkLike;
	private String isLike;
}

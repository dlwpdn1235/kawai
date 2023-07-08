package com.kawai.dto;

import lombok.Data;

@Data
public class CommDtoCommentLike {
	private int comment_id;
	private String user_id;
	private boolean checkLike;
	private String isLike;
}

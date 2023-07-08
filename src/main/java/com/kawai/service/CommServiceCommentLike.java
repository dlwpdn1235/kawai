package com.kawai.service;

import com.kawai.dto.CommDtoCommentLike;


public interface CommServiceCommentLike {
	public int commentLikeInsert(CommDtoCommentLike commentLike);
	public int commentLikeDelete(CommDtoCommentLike commentLike);
	public int commentLikeCnt(int comment_id);
}

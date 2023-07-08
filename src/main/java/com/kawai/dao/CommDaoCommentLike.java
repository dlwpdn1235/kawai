package com.kawai.dao;

import com.kawai.dto.CommDtoCommentLike;


public interface CommDaoCommentLike {
	public int commentLikeInsert(CommDtoCommentLike commentLike);
	public int commentLikeDelete(CommDtoCommentLike commentLike);
	public CommDtoCommentLike commentIsLike(CommDtoCommentLike communityLike);
	public int commentLikeCnt(int community_id);
}

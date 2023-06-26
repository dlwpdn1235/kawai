package com.kawai.dao;

import com.kawai.dto.CommDtoCommentLike;

@KawaiMapper
public interface CommDaoCommentLike {
	public int commentLikeInsert(CommDtoCommentLike commentLike);
	public int commentLikeDelete(CommDtoCommentLike commentLike);
}

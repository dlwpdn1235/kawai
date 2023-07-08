package com.kawai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.CommDaoCommentLike;
import com.kawai.dto.CommDtoCommentLike;

@Service
public class CommServiceCommentLikeImpl implements CommServiceCommentLike{

	@Autowired
	CommDaoCommentLike commentlike;
	
	@Override
	public int commentLikeInsert(CommDtoCommentLike commentLike) {
		return commentlike.commentLikeInsert(commentLike);
	}

	@Override
	public int commentLikeDelete(CommDtoCommentLike commentLike) {
		return commentlike.commentLikeDelete(commentLike);
	}
	@Override
	public int commentLikeCnt(int comment_id) {
		return commentlike.commentLikeCnt(comment_id);
	}

}

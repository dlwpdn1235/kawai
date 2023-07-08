package com.kawai.service;

import java.util.List;

import com.kawai.dto.CommDtoCommunityLike;


public interface CommServiceLike {
	public int communityLikeInsert(CommDtoCommunityLike communityLike);
	public int communityLikeDelete(CommDtoCommunityLike communityLike);
	public List<CommDtoCommunityLike> communityLikeAllRead(String user_id);
	public int communityLikeCnt(int community_id);
}
package com.kawai.dao;

import java.util.List;

import com.kawai.dto.CommDtoCommunityLike;

@KawaiMapper
public interface CommDaoLike {
	public int communityLikeInsert(CommDtoCommunityLike communityLike);
	public int communityLikeDelete(CommDtoCommunityLike communityLike);
	public List<CommDtoCommunityLike> communityLikeAllRead(String user_id);
	
}
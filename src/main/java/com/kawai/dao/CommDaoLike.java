package com.kawai.dao;

import java.util.List;
import java.util.Map;

import com.kawai.dto.CommDto;
import com.kawai.dto.CommDtoCommunityLike;


public interface CommDaoLike {
	public int communityLikeInsert(CommDtoCommunityLike communityLike);
	public int communityLikeDelete(CommDtoCommunityLike communityLike);
	public List<CommDto> communityLikeAllRead(Map<String,Object> para);
	public CommDtoCommunityLike communityIsLike(CommDtoCommunityLike communityLike);
	public int communityLikeCnt(int community_id);
}
package com.kawai.service;

import java.util.List;

import com.kawai.dto.CommDto;
import com.kawai.dto.CommDtoCommunityLike;


public interface CommServiceLike {
	public int communityLikeInsert(CommDtoCommunityLike communityLike);
	public int communityLikeDelete(CommDtoCommunityLike communityLike);
	public List<CommDto> communityLikeAllRead(String user_id, int plusPage);
	public int communityLikeCnt(int community_id);
}
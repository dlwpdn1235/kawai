package com.kawai.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.CommDaoLike;
import com.kawai.dto.CommDto;
import com.kawai.dto.CommDtoCommunityLike;

@Service
public class CommServiceLikeImpl implements CommServiceLike{

	@Autowired
	CommDaoLike like;
	
	@Override
	public int communityLikeInsert(CommDtoCommunityLike communityLike) {
		return like.communityLikeInsert(communityLike);
	}

	@Override
	public int communityLikeDelete(CommDtoCommunityLike communityLike) {
		return like.communityLikeDelete(communityLike);
	}

	@Override
	public List<CommDto> communityLikeAllRead(String user_id, int plusPage) {
		Map<String,Object> para = new HashMap<>();
		para.put("user_id", user_id);
		para.put("plusPage", plusPage);
		return like.communityLikeAllRead(para);
	}

	@Override
	public int communityLikeCnt(int community_id) {
		return like.communityLikeCnt(community_id);
	}

}

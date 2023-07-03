package com.kawai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.CommDaoLike;
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
	public List<CommDtoCommunityLike> communityLikeAllRead(String user_id) {
		return like.communityLikeAllRead(user_id);
	}

}

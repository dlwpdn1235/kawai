package com.kawai.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kawai.dao.CommDao;
import com.kawai.dao.CommDaoBookinfo;
import com.kawai.dto.CommDto;
import com.kawai.dto.CommDtoSearch;

@Service
public class CommServiceImpl implements CommService{
	
	@Autowired
	CommDao dao;
	@Autowired
	CommServiceBookinfo bookinfoservice;
	@Autowired
	CommServiceComment comment;
	

	@Transactional
	@Override
	public int commCommunityInsert(CommDto commDto) {
		int bookinfo_id = (int)bookinfoservice.commBookinfoInsert(commDto.getBookinfo());
		commDto.getBookinfo().setBookinfo_id(bookinfo_id);
		return dao.commCommunityInsert(commDto);
	}

	@Override
	public int commCommunityUpdate(CommDto commDto) {
		return dao.commCommunityUpdate(commDto);
	}

	@Override
	public int commCommunityDelete(int community_id) {
		return dao.commCommunityDelete(community_id);
	}

	@Override
	public CommDto commCommunityRead(int community_id) {
		CommDto dto =dao.commCommunityRead(community_id);
		return dto;
	}

	@Override
	public List<CommDto> commCommunityAllRead(CommDtoSearch search) {
		return dao.commCommunityAllRead(search);
	}
	
	@Transactional @Override
	public CommDto commCommunityHitRead(int community_id) {
		dao.commCommunityHit(community_id);
		CommDto dto =dao.commCommunityRead(community_id);
		dto.setComment(comment.commCommentAllRead(community_id));
		return dto;
	}
	
	@Override
	public int commHideUpdate(Map<String, Object> para) {
		return dao.commHideUpdate(para);
	}
}

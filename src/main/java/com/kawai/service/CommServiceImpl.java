package com.kawai.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kawai.dao.CommDao;
import com.kawai.dao.CommDaoLike;
import com.kawai.dto.CommDto;
import com.kawai.dto.CommDtoCommunityLike;
import com.kawai.dto.CommDtoSearch;

@Service
public class CommServiceImpl implements CommService{
	
	@Autowired
	CommDao dao;
	@Autowired
	CommServiceBookinfo bookinfoservice;
	@Autowired
	CommDaoLike like;

	@Transactional
	@Override
	public int commCommunityInsert(CommDto commDto) {
		int bookinfo_id = (int)bookinfoservice.commBookinfoInsert(commDto.getBookinfo());
		commDto.getBookinfo().setBookinfo_id(bookinfo_id);
		try {
			commDto.setCommunity_ip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dao.commCommunityInsert(commDto);
	}

	@Override
	public int commCommunityUpdate(CommDto commDto) {
		return dao.commCommunityUpdate(commDto);
	}

	@Override
	public int commCommunityDelete(int community_id) {
		Map<String, Object> para = new HashMap<>();
		para.put("community_hide", 0);
		List<Integer> list = new ArrayList<>();
		list.add(community_id);
		para.put("community_id_list", list);
		return this.commHideUpdate(para);
	}

	@Override
	public CommDto commCommunityRead(int community_id) {
		CommDto dto =dao.commCommunityRead(community_id);
		switch(dto.getComm_category_id()) {
		case 1: dto.setCategory_name("공지사항"); break;
		case 2: dto.setCategory_name("책 리뷰"); break;
		case 3: dto.setCategory_name("책 추천"); break;
		case 4: dto.setCategory_name("자유게시판"); break;
		}
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
		CommDtoCommunityLike likedto = new CommDtoCommunityLike();
		likedto.setCommunity_id(community_id);
		likedto.setUser_id("user001");
		dto.setLike(like.communityIsLike(likedto));
		switch(dto.getComm_category_id()) {
		case 1: dto.setCategory_name("공지사항"); break;
		case 2: dto.setCategory_name("책 리뷰"); break;
		case 3: dto.setCategory_name("책 추천"); break;
		case 4: dto.setCategory_name("자유게시판"); break;
		}
		return dto;
	}
	
	@Override
	public int commHideUpdate(Map<String, Object> para) {
		return dao.commHideUpdate(para);
	}

	@Override
	public List<CommDto> commUserAllRead(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}
}

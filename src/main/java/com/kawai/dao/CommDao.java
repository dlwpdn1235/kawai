package com.kawai.dao;

import java.util.List;
import java.util.Map;

import com.kawai.dto.CommDto;
import com.kawai.dto.CommDtoSearch;


public interface CommDao {
	public int commCommunityInsert(CommDto commDto);
	public int commCommunityUpdate(CommDto commDto);
	public int commCommunityDelete(int community_id);
	public CommDto commCommunityRead(int community_id);
	public List<CommDto> commCommunityAllRead(CommDtoSearch search);
	public List<CommDto> commAdminCommunityAllRead(CommDtoSearch search);
	public int commCommunityHit(int community_id);
	public int commHideUpdate(Map<String, Object> para);
	public List<CommDto> commUserAllRead(Map<String, Object> para);
	public int commCommunityCnt();
}

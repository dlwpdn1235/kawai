package com.kawai.service;

import java.util.List;
import java.util.Map;

import com.kawai.dto.CommDto;
import com.kawai.dto.CommDtoSearch;

public interface CommService {
	public int commCommunityInsert (CommDto commDto);
	public int commCommunityUpdate(CommDto commDto);
	public int commCommunityDelete(int community_id);
	public CommDto commCommunityRead(int community_id);
	public List<CommDto> commCommunityAllRead(CommDtoSearch search);
	public List<CommDto> commAdminCommunityAllRead(CommDtoSearch search);
	public CommDto commCommunityHitRead(int community_id);
	public int commHideUpdate(Map<String, Object> para);
	public List<CommDto> commUserAllRead(String user_id, int plusPage);
	public int commCommunityCnt();
}

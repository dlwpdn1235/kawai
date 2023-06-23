package com.kawai.dao;

import java.util.List;

import com.kawai.dto.CommDto;
import com.kawai.dto.CommDtoBookinfo;

@KawaiMapper
public interface CommDao {
	public int commCommunityInsert(CommDto commDto);
	public int commCommunityUpdate(CommDto commDto);
	public int commCommunityDelete(int community_id);
	public CommDto commCommunityRead(int community_id);
	public List<CommDto> commCommunityAllRead();
	public int commCommunityHit(int community_id);
}

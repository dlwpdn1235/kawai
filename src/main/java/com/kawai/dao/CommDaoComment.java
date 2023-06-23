package com.kawai.dao;

import java.util.List;

import com.kawai.dto.CommDtoComment;

@KawaiMapper
public interface CommDaoComment {
	public int commentInsert(CommDtoComment commDtoComment);
	public int commentUpdate(CommDtoComment commDtoComment);
	public int commentDelete(int CommDtoComment_id);
	public List<CommDtoComment> commCommunityAllRead(int community_id);
}

package com.kawai.dao;

import java.util.List;
import java.util.Map;

import com.kawai.dto.CommDtoComment;


public interface CommDaoComment {
	public int commentInsert(CommDtoComment commDtoComment);
	public int commentUpdate(CommDtoComment commDtoComment);
	public int commentDelete(int comment_id);
	public List<CommDtoComment> commCommentAllRead(int community_id);
	public int commSelectMax(int community_id);
	public int commCommentStepUpdate(Map<String,Integer> para);
}

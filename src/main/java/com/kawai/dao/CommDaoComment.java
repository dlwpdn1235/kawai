package com.kawai.dao;

import java.util.List;

import com.kawai.dto.CommDtoComment;


public interface CommDaoComment {
	public int commentInsert(CommDtoComment commDtoComment);
	public int commentUpdate(CommDtoComment commDtoComment);
	public int commentDelete(int CommDtoComment_id);
	public List<CommDtoComment> commCommentAllRead(int comment_id);
	public int commCommentInsert(CommDtoComment commDtoComment);
}

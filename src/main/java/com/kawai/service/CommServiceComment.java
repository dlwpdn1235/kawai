package com.kawai.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kawai.dto.CommDtoComment;


public interface CommServiceComment {
	public int commentInsert(CommDtoComment commDtoComment, HttpServletRequest request);
	public int commentUpdate(CommDtoComment commDtoComment);
	public int commentDelete(CommDtoComment commDtoComment);
	public List<CommDtoComment> commCommentAllRead(int comment_id, String user_id);
	public int commCommentStepUpdate(CommDtoComment commDtoComment);
	
}

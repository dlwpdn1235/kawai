package com.kawai.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kawai.dto.CommDtoComment;


public interface CommServiceComment {
	public List<CommDtoComment> commentInsert(CommDtoComment commDtoComment, HttpServletRequest request);
	public List<CommDtoComment> commentUpdate(CommDtoComment commDtoComment);
	public List<CommDtoComment> commentDelete(CommDtoComment commDtoComment);
	public List<CommDtoComment> commCommentAllRead(int comment_id);
	public int commCommentStepUpdate(CommDtoComment commDtoComment);
	
}

package com.kawai.dao;

import com.kawai.dto.CommDtoAnswer;


@KawaiMapper
public interface CommDaoAnswer {
	public int commAnswerInsert(CommDtoAnswer answer);
	public int commAnswerUpdate(CommDtoAnswer answer);
	public int commAnswerDelete(int inquiry_id);
	public CommDtoAnswer commAnswerRead(int inquiry_id);
	public boolean commAnswerIs(int inquiry_id);
}

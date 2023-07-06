package com.kawai.service;

import com.kawai.dto.CommDtoAnswer;



public interface CommServiceAnswer {
	public int commAnswerInsert(CommDtoAnswer answer);
	public int commAnswerUpdate(CommDtoAnswer answer);
	public int commAnswerDelete(int inquiry_id);
	public CommDtoAnswer commAnswerRead(int inquiry_id);
	public boolean commAnswerIs(int inquiry_id);
}

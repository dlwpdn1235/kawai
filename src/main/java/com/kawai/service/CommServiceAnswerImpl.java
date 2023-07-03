package com.kawai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.CommDaoAnswer;
import com.kawai.dto.CommDtoAnswer;

@Service
public class CommServiceAnswerImpl implements CommServiceAnswer{

	@Autowired
	CommDaoAnswer answerdao;
	
	@Override
	public int commAnswerInsert(CommDtoAnswer answer) {
		return answerdao.commAnswerInsert(answer);
	}

	@Override
	public int commAnswerUpdate(CommDtoAnswer answer) {
		return answerdao.commAnswerUpdate(answer);
	}

	@Override
	public int commAnswerDelete(int inquiry_id) {
		return answerdao.commAnswerDelete(inquiry_id);
	}

	@Override
	public CommDtoAnswer commAnswerRead(int inquiry_id) {
		return answerdao.commAnswerRead(inquiry_id);
	}

	@Override
	public boolean commAnswerIs(int inquiry_id) {
		return answerdao.commAnswerIs(inquiry_id);
	}

}

package com.kawai.dao;

import java.util.List;

import com.kawai.dto.CommDtoInquiry;

@KawaiMapper
public interface CommDaoInquiry {
	public int commInquiryInsert(CommDtoInquiry inquiry);
	public int commInquiryUpdate(CommDtoInquiry inquiry);
	public int commInquiryDelete(int inquiry_id);
	public CommDtoInquiry commInquiryRead(int inquiry_id);
	public List<CommDtoInquiry> commInquiryAllRead(String user_id);
}

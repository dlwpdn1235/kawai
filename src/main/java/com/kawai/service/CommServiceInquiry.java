package com.kawai.service;

import java.util.List;
import java.util.Map;

import com.kawai.dto.CommDtoInquiry;


public interface CommServiceInquiry {
	public int commInquiryInsert(CommDtoInquiry inquiry);
	public int commInquiryUpdate(CommDtoInquiry inquiry);
	public int commInquiryDelete(int inquiry_id);
	public CommDtoInquiry commInquiryRead(int inquiry_id);
	public List<CommDtoInquiry> commInquiryAllRead(Map<String,String> para);
}

package com.kawai.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.CommDaoInquiry;
import com.kawai.dto.CommDtoInquiry;

@Service
public class CommServiceInquiryImpl implements CommServiceInquiry{

	@Autowired
	CommDaoInquiry inquirydao;
	
	@Override
	public int commInquiryInsert(CommDtoInquiry inquiry) {
		return inquirydao.commInquiryInsert(inquiry);
	}

	@Override
	public int commInquiryUpdate(CommDtoInquiry inquiry) {
		return inquirydao.commInquiryUpdate(inquiry);
	}

	@Override
	public int commInquiryDelete(int inquiry_id) {
		return inquirydao.commInquiryDelete(inquiry_id);
	}

	@Override
	public CommDtoInquiry commInquiryRead(int inquiry_id) {
		return inquirydao.commInquiryRead(inquiry_id);
	}

	@Override
	public List<CommDtoInquiry> commInquiryAllRead(Map<String, String> para) {
		return inquirydao.commInquiryAllRead(para);
	}

}

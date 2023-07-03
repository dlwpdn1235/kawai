package com.kawai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kawai.dao.CommDaoBookinfo;
import com.kawai.dto.CommDtoBookinfo;

@Service
public class CommServiceBookinfoImpl implements CommServiceBookinfo{

	@Autowired
	CommDaoBookinfo bookinfodao;
	
	@Transactional
	@Override
	public int commBookinfoInsert(CommDtoBookinfo bookinfo) {
		Integer bookinfo_id = bookinfodao.commBookinfoCheck(bookinfo);
		if(bookinfo_id==null) {
			bookinfodao.commBookinfoInsert(bookinfo);
			bookinfo_id = bookinfodao.commBookinfoCheck(bookinfo);
		}
		return bookinfo_id;
	}

	@Override
	public int commBookinfoUpdate(CommDtoBookinfo bookinfo) {
		return bookinfodao.commBookinfoUpdate(bookinfo);
	}

	@Override
	public int commBookinfoDelete(int bookinfo_id) {
		return bookinfodao.commBookinfoDelete(bookinfo_id);
	}

}

package com.kawai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.BookHashTagDao;
import com.kawai.dto.BookHashTagVO;

@Service
public class BookHashTagServiceImpl implements BookHashTagService{
	@Autowired BookHashTagDao dao;
	
	@Override
	public int taginsert(BookHashTagVO vo) { return dao.taginsert(vo); }
	@Override
	public int tagupdate(BookHashTagVO vo) { return dao.tagupdate(vo); }
	@Override
	public int tagdelete(int no) { return dao.tagdelete(no); }
	@Override
	public BookHashTagVO tagread(int no) { return dao.tagread(no); }
	@Override
	public List<BookHashTagVO> tagreadAll() { return dao.tagreadAll(); }

}

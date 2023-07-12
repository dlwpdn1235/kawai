


package com.kawai.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.BookHashTagDao;
import com.kawai.dao.BookTagBoxDao;
import com.kawai.dto.BookHashTagVO;
import com.kawai.dto.BookTagBoxVO;

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
	@Override
	public BookTagBoxVO findTagByName(String tagName) {
		
		return null;
	}
	@Override
	public List<String> findTagNamesByIds(List<Integer> tagIds) {
		return dao.findTagNamesByIds(tagIds);
	}
	@Override
	public String getTagNameByTagId(Integer tagId) {
		return dao.getTagNameByTagId(tagId);
	}

}

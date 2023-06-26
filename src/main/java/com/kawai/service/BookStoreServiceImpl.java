package com.kawai.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.BookStoreDao;
import com.kawai.dto.BookStoreVO;

@Service("bookStoreService")
public class BookStoreServiceImpl implements BookStoreService {
	@Autowired BookStoreDao dao;

	
	@Override public int insert(BookStoreVO vo) { return dao.bookstoreinsert(vo); }
	@Override public int update(BookStoreVO vo) { return dao.bookstoreupdate(vo); }
	@Override public int delete(int no) { return dao.bookstoredelete(no); }
	@Override public BookStoreVO read(int no) { return dao.bookstoreread(no); }
	@Override public List<BookStoreVO> readAll() { return dao.bookstorereadAll(); }
//	@Override
//	public List<BookStoreVO> search(String searchtype, String keyword) {
//	    Map<String, String> searchParam = new HashMap<>();
//	    searchParam.put("type", searchtype);
//	    searchParam.put("word", keyword);
//	    List<BookStoreVO> bList = dao.search(searchParam);
//	    return bList;
//	}
	@Override
	public List<BookStoreVO> search(String searchtype, String keyword) {
		return null;
	}
	@Override
	public int getSearchTotalCount(String searchtype, String keyword) {
		 int totalCount = dao.getSearchTotalCount(searchtype, keyword);
		 return totalCount;
	}
	

}

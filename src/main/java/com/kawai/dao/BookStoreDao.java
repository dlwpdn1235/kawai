package com.kawai.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.kawai.dto.BookStoreVO;

public interface BookStoreDao {
	// CRUD  -- update
	public int bookstoreinsert(BookStoreVO vo);
	public int bookstoreupdate(BookStoreVO vo);
	public int bookstoredelete(int no); 
	// CRUD  -- selectOne (1개)  selectList(여러줄)
	public  BookStoreVO bookstoreread(int no);
	public  List<BookStoreVO>  bookstorereadAll();
	
	//public int getSearchTotalCount(String searchtype, String keyword);
	//검색
	//public List<BookStoreVO> search(Map<String, String> searchParam);
	
}

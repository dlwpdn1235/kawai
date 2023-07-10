package com.kawai.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.kawai.dto.BookStoreVO;
import com.kawai.dto.BookTagBoxVO;

public interface BookStoreDao {
	public int bookstoreinsert(BookStoreVO vo);
	public int bookstoreupdate(BookStoreVO vo);
	public int bookstoredelete(int no); 
	public  BookStoreVO bookstoreread(int no);
	public  List<BookStoreVO>  bookstorereadAll();
	
	public Integer findMaxBsNo();
	
	
	public void addBookTagBox(BookTagBoxVO tagBox);
	
	
	public List<String> getBookStoreTagNames(int no);
	
	
	public List<BookStoreVO> getBsName(String name);
	
	
	public void registerBookStore(BookStoreVO vo);
	//public int getSearchTotalCount(String searchtype, String keyword);
	//검색
	//public List<BookStoreVO> search(Map<String, String> searchParam);
	
}

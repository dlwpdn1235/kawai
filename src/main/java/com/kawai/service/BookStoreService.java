package com.kawai.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.kawai.dto.BookImgVO;
import com.kawai.dto.BookStoreVO;

public interface BookStoreService {
	public int bookstoreinsert(BookStoreVO vo);
	public int bookstoreupdate(BookStoreVO vo);
	public int bookstoredelete(int no); 
	public  BookStoreVO bookstoreread(int no);
	public  List<BookStoreVO>  bookstorereadAll();
	
	//public int getSearchTotalCount(String searchtype, String keyword);
	//검색
	//public List<BookStoreVO> search(Map<String, String> searchParam);
	
}

package com.kawai.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.kawai.dto.BookImgVO;
import com.kawai.dto.BookStoreVO;
import com.kawai.dto.BookTagBoxVO;

public interface BookStoreService {
	public int bookstoreinsert(MultipartFile file, HttpServletRequest request , BookStoreVO vo);
	public int bookstoreupdate(MultipartFile file, HttpServletRequest request , BookStoreVO vo);
	public int bookstoredelete(int no); 
	public  BookStoreVO bookstoreread(BookStoreVO  vo);
	public  List<BookStoreVO>  bookstorereadAll();
	
	public Integer findMaxBsNo();
	
	public void addBookTagBox(BookTagBoxVO tagBox);
	
	// Storeservice 인터페이스에 메소드 추가
	public List<String> getBookStoreTagNames(int no);
	
	//bs_name을 찾아서 detail에 넘기기
	public List<BookStoreVO> getBsName(String name);
	
	//bs_no 설정
	public void registerBookStore(BookStoreVO vo);
	
	//public int getSearchTotalCount(String searchtype, String keyword);
	//검색
	//public List<BookStoreVO> search(Map<String, String> searchParam);
	
	
	
}

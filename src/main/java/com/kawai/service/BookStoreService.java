package com.kawai.service;

import java.util.List;
import com.kawai.dto.BookStoreVO;

public interface BookStoreService {
	public int insert(BookStoreVO vo);
	public int update(BookStoreVO vo);
	public int delete(int no);
	public BookStoreVO read(int no);
	public List<BookStoreVO> readAll();
	
	//public List<BookStoreVO> search(String searchtype, String keyword);
	List<BookStoreVO> search(String searchtype, String keyword);
    int getSearchTotalCount(String searchtype, String keyword);
}

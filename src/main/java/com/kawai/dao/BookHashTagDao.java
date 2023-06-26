package com.kawai.dao;

import java.util.List;

import com.kawai.dto.BookHashTagVO;

@KawaiMapper
public interface BookHashTagDao {
	// CRUD  -- update
	public int bookinsert(BookHashTagVO vo);
	public int update(BookHashTagVO vo);
	public int delete(int no); 
	// CRUD  -- selectOne (1개)  selectList(여러줄)
	public  BookHashTagVO read(int no);
	public  List<BookHashTagVO>  readAll();
}

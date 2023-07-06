package com.kawai.dao;

import java.util.List;

import com.kawai.dto.BookHashTagVO;

public interface BookHashTagDao {
	// CRUD  -- update
	public int taginsert(BookHashTagVO vo);
	public int tagupdate(BookHashTagVO vo);
	public int tagdelete(int no); 
	// CRUD  -- selectOne (1개)  selectList(여러줄)
	public  BookHashTagVO tagread(int no);
	public  List<BookHashTagVO>  tagreadAll();
}

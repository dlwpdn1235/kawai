package com.kawai.dao;

import java.util.List;

import com.kawai.dto.BookImgVO;

public interface BookImgDao {
	// CRUD  -- update
	public int imginsert(BookImgVO vo);
	public int imgupdate(BookImgVO vo);
	public int imgdelete(int no); 
	// CRUD  -- selectOne (1개)  selectList(여러줄)
	public  BookImgVO imgread(int no);
	public  List<BookImgVO>  imgreadAll();
}

package com.kawai.dao;

import java.util.List;

import com.kawai.dto.BookImgVO;
import com.kawai.dto.BookLikesVO;

public interface BookLikesDao {
	// CRUD  -- update
	public int likesinsert(BookLikesVO vo);
	public int likesupdate(BookLikesVO vo);
	public int likesdelete(int no); 
	// CRUD  -- selectOne (1개)  selectList(여러줄)
	public  BookLikesVO likesread(int no);
	public  List<BookLikesVO>  likesreadAll();
}

package com.kawai.service;

import java.util.List;

import com.kawai.dto.BookImgVO;
import com.kawai.dto.BookLikesVO;

public interface BookLikesService {
	public int likesinsert(BookLikesVO vo);
	//public int likesupdate(BookLikesVO vo);
	public int likesdelete(int no); 
	public  BookLikesVO likesread(int no);
	public  List<BookLikesVO>  likesreadAll();
}

package com.kawai.dao;

import java.util.List;

import com.kawai.dto.BookImgVO;

public interface BookImgDao {
	public List<BookImgVO>        imglist();
	public int imginsert(BookImgVO vo);
	public  BookImgVO imgread(BookImgVO vo);
	public int imgupdate(BookImgVO vo);
	public int imgdelete(int no); 
	public  List<BookImgVO>  imgreadAll();
	
//	public List<BookImgVO> getImgsByBsNo(int bsNo);
//	
//	public String getImgFileNameByBsNo(int bsNo);
//	public String getImgFileNameByBsNoAndImgNo(int bsNo, int imgNo);
//	public int   update_hit(BoardVO vo);
}

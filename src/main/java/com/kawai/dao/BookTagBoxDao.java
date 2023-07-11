package com.kawai.dao;

import java.util.List;

import com.kawai.dto.BookHashTagVO;
import com.kawai.dto.BookTagBoxVO;

public interface BookTagBoxDao {
	public int boxinsert(BookTagBoxVO vo);
	public int boxupdate(BookTagBoxVO vo);
	public int boxdelete(int no); 
	public  BookTagBoxVO boxread(int no);
	
	public  List<BookTagBoxVO>  boxreadAll();
	
	public void boxtaginsert(List<BookTagBoxVO> tagBoxes);
	
	// bs_no에 해당하는 해시태그 목록 조회
	public List<Integer> findTagIdsByBsNo(int bsNo);
	
	public List<BookTagBoxVO> findTagByName();
	
	public List<BookTagBoxVO> findTagByName2(BookTagBoxVO vo);
	
	
	
	
}

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
	
	
	// tag_id를 사용하여 실제 해시태그 값을 가져오기
	public List<String> findTagNamesByIds(List<Integer> tagIds);
	
	
	
	public String getTagNameByTagId(Integer tagId);
}

package com.kawai.service;

import java.util.List;

import com.kawai.dto.BookHashTagVO;
import com.kawai.dto.BookTagBoxVO;

public interface BookHashTagService {
	public int taginsert(BookHashTagVO vo);
	public int tagupdate(BookHashTagVO vo);
	public int tagdelete(int no); 
	public  BookHashTagVO tagread(int no);
	public  List<BookHashTagVO>  tagreadAll();
	
	public List<String> findTagNamesByIds(List<Integer> tagIds);
	
	
	public String getTagNameByTagId(Integer tagId);
	
	public BookTagBoxVO findTagByName(String tagName);
}

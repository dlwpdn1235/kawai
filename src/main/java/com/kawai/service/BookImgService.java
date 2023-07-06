package com.kawai.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.kawai.dto.BookImgVO;

public interface BookImgService {
	public int imginsert(MultipartFile file, HttpServletRequest request,BookImgVO vo);
	public int imgupdate(BookImgVO vo);
	public int imgdelete(int no); 
	public  BookImgVO imgread(int no);
	public  List<BookImgVO>  imgreadAll();
}

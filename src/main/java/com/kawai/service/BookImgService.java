package com.kawai.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.kawai.dto.BookImgVO;

public interface BookImgService {
	public List<BookImgVO>        imglist();
	public String imginsert(MultipartFile file, HttpServletRequest request ,BookImgVO vo);
	public  BookImgVO imgread(BookImgVO vo);
	public int imgupdate(MultipartFile file, HttpServletRequest request ,BookImgVO vo);
	public int imgdelete(int no); 
	public  List<BookImgVO>  imgreadAll();
	
//	public List<BookImgVO> getImgsByBsNo(int bsNo);
//	public String getImgFileNameByBsNo(int bsNo);
//	public String getImgFileNameByBsNoAndImgNo(int bsNo, int imgNo);
}

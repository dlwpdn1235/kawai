package com.kawai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.BookLikesDao;
import com.kawai.dto.BookLikesVO;

@Service
public class BookLikesServiceImpl implements BookLikesService{
	@Autowired BookLikesDao dao;
	
	@Override
	public int likesinsert(BookLikesVO vo) {
		return dao.likesinsert(vo);
	}

	@Override
	public int likesdelete(int no) {
		return dao.likesdelete(no);
	}

	@Override
	public BookLikesVO likesread(int no) {
		return dao.likesread(no);
	}

	@Override
	public List<BookLikesVO> likesreadAll() {
		return dao.likesreadAll();
	}

}

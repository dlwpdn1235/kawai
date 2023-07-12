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
	public void insertBookLikes(BookLikesVO bookLikes) {
		dao.insertBookLikes(bookLikes);
	}

	@Override
	public void deleteBookLikes(BookLikesVO bookLikes) {
		dao.deleteBookLikes(bookLikes);
	}

	@Override
	public boolean checkLikes(String fk_id, String fk_bs_no) {
		return dao.checkLikes(fk_id, fk_bs_no);
	}
	
	


}

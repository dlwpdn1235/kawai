package com.kawai.service;

import java.util.List;

import com.kawai.dto.BookImgVO;
import com.kawai.dto.BookLikesVO;

public interface BookLikesService {
	public void insertBookLikes(BookLikesVO bookLikes);
    public void deleteBookLikes(BookLikesVO bookLikes);
    public boolean checkLikes(String fk_id, String fk_bs_no);
}

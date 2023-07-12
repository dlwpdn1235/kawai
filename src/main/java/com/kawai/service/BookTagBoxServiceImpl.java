package com.kawai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.BookHashTagDao;
import com.kawai.dao.BookTagBoxDao;
import com.kawai.dto.BookHashTagVO;
import com.kawai.dto.BookTagBoxVO;

@Service
public class BookTagBoxServiceImpl implements BookTagBoxService{
	@Autowired BookTagBoxDao dao;

	@Override public int boxinsert(BookTagBoxVO vo) { return dao.boxinsert(vo); }

	@Override public int boxupdate(BookTagBoxVO vo) { return dao.boxupdate(vo); }

	@Override public int boxdelete(int no) { return dao.boxdelete(no); }

	@Override public BookTagBoxVO boxread(int no) { return dao.boxread(no); }

	@Override public List<BookTagBoxVO> boxreadAll() { return dao.boxreadAll(); }
	
	@Override
	public void boxtaginsert(List<BookTagBoxVO> tagBoxes) {
		 if (tagBoxes.isEmpty()) {
		        System.out.println("Tag Boxes list is empty.");
		        return; // 빈 리스트일 경우 처리 종료
		    }
		    
		    for (BookTagBoxVO tagBox : tagBoxes) {
		        dao.boxtaginsert(tagBoxes);
		        System.out.println("Tag Box: " + tagBox);
		    }
	}

	@Override
	public List<BookTagBoxVO> findTagByName() {
		return dao.findTagByName();
	}

	@Override
	public List<Integer> findTagIdsByBsNo(int bsNo) {
		return dao.findTagIdsByBsNo(bsNo);
	}

	@Override
	public List<BookTagBoxVO> findTagByName2(BookTagBoxVO vo) {
		return dao.findTagByName2(vo);
	}




}

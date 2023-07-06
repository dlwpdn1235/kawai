package com.kawai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.CommDaoCategory;
import com.kawai.dto.CommDtoCategory;

@Service
public class CommServiceCategoryImpl implements CommServiceCategory{

	@Autowired CommDaoCategory comm_dao_cateogry;
	@Override
	public List<CommDtoCategory> commCategoryList() {
		return comm_dao_cateogry.commCategoryList();
	}

}

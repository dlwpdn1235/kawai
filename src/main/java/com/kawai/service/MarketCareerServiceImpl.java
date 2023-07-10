package com.kawai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.MarketCareerDao;
import com.kawai.dto.MarketCart;

@Service
public class MarketCareerServiceImpl implements MarketCareerService{

	@Autowired
	MarketCareerDao dao;
	
	@Override
	public int marketCareerInsert(MarketCart cdto) {
		
		int result = dao.marketCareerInsert(cdto);
		return result;
	}

	@Override
	public int marketCareerDelete(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int marketCareerUpdate(MarketCart cdto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MarketCart> marketCareerList(MarketCart cdto) {
		// TODO Auto-generated method stub
		return null;
	}

}

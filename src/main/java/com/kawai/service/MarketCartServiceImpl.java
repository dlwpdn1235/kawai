package com.kawai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kawai.dao.MarketCartDao;
import com.kawai.dto.MarketCart;
@Service
public class MarketCartServiceImpl implements MarketCartService{

	@Autowired
	MarketCartDao dao;

	@Transactional
	@Override
	public int marketCartInsert(MarketCart dto) {
		int result = dao.marketCartInsert(dto);
		result += dao.marketCartCountUpdate(dto);
		return result;
	}

	@Override
	public int marketCartUpdate(MarketCart dto) {
		return dao.marketCartUpdate(dto);
	}

	@Transactional
	@Override
	public int marketCartDelete(int no) {
		MarketCart dto = new MarketCart();
		int result = dao.marketCartDelete(no);
		result += dao.marketCartUpdate(dto);
		return result;
	}

	@Override
	public List<MarketCart> marketCartList() {
		
		return dao.marketCartList();
	}

	@Override
	public MarketCart marketCartRead(int no) {
		MarketCart dto = new MarketCart();
		dto.setUser_id("user001");
		
		return dao.marketCartRead(no);
	}
	

}

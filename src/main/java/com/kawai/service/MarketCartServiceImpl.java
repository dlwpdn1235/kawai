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
	public int marketCartDelete(MarketCart dto) {
		int result = dao.marketCartDelete(dto);
		result += dao.marketCartCountUpdate(dto);
		return result;
	}

	@Override
	public List<MarketCart> marketCartList(String user_id) {
		System.out.println(user_id);
		return dao.marketCartList(user_id);
	}

	@Override
	public int marketCartCount(int no) {
		MarketCart cdto = new MarketCart();
		no = dao.marketCartCountUpdate(cdto);
		return no;
	}




	

}

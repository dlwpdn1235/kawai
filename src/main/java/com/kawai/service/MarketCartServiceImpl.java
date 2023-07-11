package com.kawai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kawai.dao.MarketCartDao;
import com.kawai.dto.MarketCart;
import com.kawai.dto.MarketDto;
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
		int result = dao.marketCartDelete(dto.getMCart_id());
		result += dao.marketCartCountUpdate(dto);
		return result;
	}

	@Override
	public List<MarketCart> marketCartList(String user_id) {
		return dao.marketCartList(user_id);
	}


	

}

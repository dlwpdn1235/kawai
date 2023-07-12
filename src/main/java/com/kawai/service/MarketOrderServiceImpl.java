package com.kawai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.MarketOrderDao;
import com.kawai.dto.MarketDto;
import com.kawai.dto.MarketOrderDto;


@Service
public class MarketOrderServiceImpl implements MarketOrderService{

	@Autowired
	MarketOrderDao dao;
	
	
	@Override
	public int marketOrderInsert(MarketOrderDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int marketOrderUpdate(MarketOrderDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int marketOrderDelete(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int marketOrderSum(MarketDto mdto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MarketOrderDto> mOrderReadAll(String user_id) {
		List<MarketOrderDto> result = dao.mOrderReadAll(user_id);
		return result;
	}

}

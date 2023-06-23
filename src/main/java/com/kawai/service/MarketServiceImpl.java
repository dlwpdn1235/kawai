package com.kawai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.MarketProductMapper;
import com.kawai.dto.CommDtoBookinfo;
import com.kawai.dto.MarketDto;
import com.kawai.dto.MarketPayDto;

@Service("MarketService")
public class MarketServiceImpl implements MarketService{
	
	@Autowired
	MarketProductMapper dao;

	@Override
	public int marketInsert(MarketDto dto) {
		
		return dao.marketInsert(dto);
	}

	@Override
	public int marketUpdate(MarketDto dto) {
		// TODO Auto-generated method stub
		return dao.marketUpdate(dto);
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return dao.marketDelete(no);
	}

	@Override
	public MarketDto read(int no) {
		// TODO Auto-generated method stub
		return dao.marketRead(no);
	}

	@Override
	public List<MarketDto> readAll() {
		// TODO Auto-generated method stub
		return dao.marketList();
	}

	@Override
	public int marketCount(MarketPayDto dto) {
		// TODO Auto-generated method stub
		return dto.getmPayCount();
	}

	@Override
	public List<CommDtoBookinfo> bookinfo() {
		// TODO Auto-generated method stub
		return null;
	}

}

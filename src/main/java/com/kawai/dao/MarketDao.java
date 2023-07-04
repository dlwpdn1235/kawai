package com.kawai.dao;

import java.util.List;

import com.kawai.dto.MarketDto;
import com.kawai.dto.MarketPageDto;


public interface MarketDao {
	public int marketInsert(MarketDto dto); 
	public int marketUpdate(MarketDto dto); 
	public int marketYear();
	public int marketMonth();
	public MarketDto marketRead(int no);
	public MarketDto marketList();
	public List<MarketDto> marketList(MarketPageDto dto);
}
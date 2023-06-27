package com.kawai.dao;

import java.util.List;

import com.kawai.dto.MarketDto;
import com.kawai.dto.MarketPageDto;


public interface MarketDao {
	public int marketInsert(MarketDto dto);
	public int marketUpdate(MarketDto dto);
	public int marketDelete(int no);
	public MarketDto marketRead(int no);
	public List<MarketDto> marketList(MarketPageDto dto);
}
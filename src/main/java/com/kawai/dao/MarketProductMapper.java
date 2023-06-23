package com.kawai.dao;

import java.util.List;

import com.kawai.dto.MarketDto;

@KawaiMapper
public interface MarketProductMapper {
	public int marketInsert(MarketDto dto);
	public int marketUpdate(MarketDto dto);
	public int marketDelete(int no);
	
	public MarketDto marketRead(int no);
	public List<MarketDto> marketList();
}


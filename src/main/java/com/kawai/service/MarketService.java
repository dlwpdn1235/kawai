package com.kawai.service;

import java.util.List;

import com.kawai.dto.MarketDto;
import com.kawai.dto.MarketPageDto;


public interface MarketService {
	public int marketInsert(MarketDto dto); 
	public int marketUpdate(MarketDto dto); 
	public MarketDto marketRead(int no);
	public List<MarketDto> marketList(MarketPageDto dto);
	public int commBookinfoInsert(MarketDto dto);
}
package com.kawai.service;

import java.util.List;

import com.kawai.dto.MarketPayDto;


public interface MarketPayService {
	public int marketPayInsert(MarketPayDto dto);
	public int marketPayUpdate(MarketPayDto dto);
	public int marketPayDelete(int no);
	public List<MarketPayDto> marketPayList();
}

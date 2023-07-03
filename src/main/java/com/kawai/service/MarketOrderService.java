package com.kawai.service;

import java.util.List;

import com.kawai.dto.MarketDto;
import com.kawai.dto.MarketOrderDto;


public interface MarketOrderService {
	public int marketOrderInsert(MarketOrderDto dto);
	public int marketOrderUpdate(MarketOrderDto dto);
	public int marketOrderDelete(int no);
	public int marketOrderSum(MarketDto mdto);
	public List<MarketOrderDto> mOrderReadAll();
}

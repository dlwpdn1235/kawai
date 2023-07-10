package com.kawai.dao;

import java.util.List;

import com.kawai.dto.MarketDto;
import com.kawai.dto.MarketOrderDto;

public interface MarketProductDao {
	public List<MarketDto> marketProductList (MarketOrderDto moDto);
}

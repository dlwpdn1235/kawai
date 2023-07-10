package com.kawai.service;

import java.util.List;

import com.kawai.dto.MarketDto;
import com.kawai.dto.MarketOrderDto;

public interface MarketProductService {
	public List<MarketDto> marketProductList (MarketOrderDto moDto); 
}

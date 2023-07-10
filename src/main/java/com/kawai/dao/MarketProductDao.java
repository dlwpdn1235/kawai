package com.kawai.dao;

import java.util.List;

import com.kawai.dto.MarketDto;
import com.kawai.dto.MarketOrderDto;

public interface MarketProductDao {
	public int marketProductInsert (MarketDto Dto);
	public int marketProductUpdate (MarketDto Dto);
	public int marketProductDelete (int no);
	public List<MarketDto> marketProductReadAll (MarketOrderDto oDto);
	public int marketProductRead (int no);
}
